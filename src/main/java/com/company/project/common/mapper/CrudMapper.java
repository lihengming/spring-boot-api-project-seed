package com.company.project.common.mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *  基础增删改查功能mapper
 * @author LErry.li
 * Date: 2018-06-16
 * Time: 12:49
 */
public interface CrudMapper<T> extends
        InsertMapper<T>,
        DeleteMapper<T>,
        UpdateMapper<T>,
        SelectMapper<T>  {
}
