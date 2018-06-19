package com.company.project.common.mapper;

import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.base.select.*;
import tk.mybatis.mapper.common.condition.SelectByConditionMapper;
import tk.mybatis.mapper.common.condition.SelectCountByConditionMapper;
import tk.mybatis.mapper.common.example.SelectByExampleMapper;
import tk.mybatis.mapper.common.ids.SelectByIdsMapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *  基础查询功能mapper
 * @author LErry.li
 * Date: 2018-06-16
 * Time: 12:48
 */
public interface SelectMapper<T> extends Marker,
        SelectOneMapper<T>,
        tk.mybatis.mapper.common.base.select.SelectMapper<T>,
        SelectAllMapper<T>,
        SelectCountMapper<T>,
        SelectByPrimaryKeyMapper<T>,
        ExistsWithPrimaryKeyMapper<T>,
        SelectByIdsMapper<T>,
        SelectByConditionMapper<T>,
        SelectCountByConditionMapper<T>,
        SelectByExampleMapper<T> {
}
