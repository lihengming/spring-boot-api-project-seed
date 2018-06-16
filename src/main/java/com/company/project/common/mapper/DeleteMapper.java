package com.company.project.common.mapper;

import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.base.delete.DeleteByPrimaryKeyMapper;
import tk.mybatis.mapper.common.condition.DeleteByConditionMapper;
import tk.mybatis.mapper.common.ids.DeleteByIdsMapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *  基础删除功能mapper
 * @author LErry.li
 * Date: 2018-06-16
 * Time: 12:46
 */
public interface DeleteMapper<T> extends Marker,
        tk.mybatis.mapper.common.base.delete.DeleteMapper<T>,
        DeleteByPrimaryKeyMapper<T>,
        DeleteByConditionMapper<T>,
        DeleteByIdsMapper<T> {
}
