package com.company.project.core;


import com.company.project.common.annotations.ServiceLog;
import com.company.project.common.exception.BusinessException;
import com.company.project.common.mapper.CrudMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 * @author lerry
 */
public abstract class AbstractService<T> implements Service<T> {

    @Autowired
    protected CrudMapper<T> mapper;

    /**
     *  当前泛型真实类型的Class
     */
    private Class<T> modelClass;

    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    @ServiceLog(description = "持久化")
    public void save(T model) {
        mapper.insertSelective(model);
    }

    @Override
    @ServiceLog(description = "批量持久化")
    public void save(List<T> models) {
        mapper.insertList(models);
    }

    @Override
    @ServiceLog(description = "通过主鍵刪除")
    public void deleteById(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    @ServiceLog(description = "通过主鍵批量刪除")
    public void deleteByIds(String ids) {
        mapper.deleteByIds(ids);
    }

    @Override
    @ServiceLog(description = "更新")
    public void update(T model) {
        mapper.updateByPrimaryKeySelective(model);
    }

    @Override
    @ServiceLog(description = "通过ID查找")
    public T findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    @ServiceLog(description = "通过多个ID查找")
    public List<T> findByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    @Override
    @ServiceLog(description = "根据条件查找")
    public List<T> findByCondition(Condition condition) {
        return mapper.selectByCondition(condition);
    }

    @Override
    @ServiceLog(description = "获取所有")
    public List<T> findAll() {
        return mapper.selectAll();
    }

    @Override
    @ServiceLog(description = "根据自定义条件查找")
    public T findBy(String fieldName, Object value) throws BusinessException {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return mapper.selectOne(model);
        } catch (ReflectiveOperationException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }

}
