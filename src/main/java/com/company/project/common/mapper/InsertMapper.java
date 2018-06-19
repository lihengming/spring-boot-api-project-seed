package com.company.project.common.mapper;

import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.base.insert.InsertSelectiveMapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *  基础插入功能mapper
 * @author LErry.li
 * Date: 2018-06-16
 * Time: 12:44
 */
public interface InsertMapper<T> extends Marker,
        tk.mybatis.mapper.common.base.insert.InsertMapper<T>,
        InsertSelectiveMapper<T>,
        MySqlMapper<T> {
}
