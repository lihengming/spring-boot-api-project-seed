package com.company.project.common.util;

import com.alibaba.fastjson.JSON;
import com.company.project.common.result.ParameterInvalidItem;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 * Description:
 *  类转化工具类
 * @author LErry.li
 * Date: 2018-06-15
 * Time: 14:42
 */
public class ConvertUtil {

    private ConvertUtil() {

    }

    public static List<ParameterInvalidItem> convertCVSetToParameterInvalidItemList(Set<ConstraintViolation<?>> cvset) {
        if (CollectionUtils.isEmpty(cvset)) {
            return Collections.emptyList();
        }
        char ch = '.';
        List<ParameterInvalidItem> parameterInvalidItemList = Lists.newArrayList();
        for (ConstraintViolation<?> cv : cvset) {
            ParameterInvalidItem parameterInvalidItem = new ParameterInvalidItem();
            String propertyPath = cv.getPropertyPath().toString();
            if (propertyPath.indexOf(ch) != -1) {
                String[] propertyPathArr = propertyPath.split("\\.");
                parameterInvalidItem.setFieldName(propertyPathArr[propertyPathArr.length - 1]);
            } else {
                parameterInvalidItem.setFieldName(propertyPath);
            }
            parameterInvalidItem.setMessage(cv.getMessage());
            parameterInvalidItemList.add(parameterInvalidItem);
        }

        return parameterInvalidItemList;
    }

    public static List<ParameterInvalidItem> convertBindingResultToMapParameterInvalidItemList(BindingResult bindingResult) {
        if (bindingResult == null) {
            return Collections.emptyList();
        }

        List<ParameterInvalidItem> parameterInvalidItemList = Lists.newArrayList();

        List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrorList) {
            ParameterInvalidItem parameterInvalidItem = new ParameterInvalidItem();
            parameterInvalidItem.setFieldName(fieldError.getField());
            parameterInvalidItem.setMessage(fieldError.getDefaultMessage());
            parameterInvalidItemList.add(parameterInvalidItem);
        }

        return parameterInvalidItemList;
    }

    public static Map<String, Object> convertBeanToMap(Object object) {
        if (object == null) {
            return Collections.emptyMap();
        }
        return JSON.parseObject(JSON.toJSONString(object));
    }
}