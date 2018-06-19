package com.company.project.common.mapper;

import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.base.update.UpdateByPrimaryKeyMapper;
import tk.mybatis.mapper.common.base.update.UpdateByPrimaryKeySelectiveMapper;
import tk.mybatis.mapper.common.condition.UpdateByConditionMapper;
import tk.mybatis.mapper.common.condition.UpdateByConditionSelectiveMapper;
import tk.mybatis.mapper.common.example.UpdateByExampleSelectiveMapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *  基础更新功能mapper
 * @author LErry.li
 * Date: 2018-06-16
 * Time: 12:47
 */
public interface UpdateMapper <T> extends Marker,
        UpdateByPrimaryKeyMapper<T>,
        UpdateByPrimaryKeySelectiveMapper<T>,
        UpdateByConditionMapper<T>,
        UpdateByConditionSelectiveMapper<T>,
        UpdateByExampleSelectiveMapper<T> {
}
