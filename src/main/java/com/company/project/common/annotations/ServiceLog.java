package com.company.project.common.annotations;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *  AOP日志记录，自定义注解
 * @author LErry.li
 * Date: 2018-06-17
 * Time: 14:45
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLog {

    /**
     * 日志描述
     */
    String description()  default "";
}
