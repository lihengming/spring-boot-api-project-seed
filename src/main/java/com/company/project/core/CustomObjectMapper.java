package com.company.project.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * 定制 Jackson 的 ObjectMapper
 *
 * @author
 * @since 1.0.0
 */
@Component
public class CustomObjectMapper extends ObjectMapper {

    private static final long serialVersionUID = 1L;

    public CustomObjectMapper() {
        super();
        init();
    }

    public void init() {
        // 排除值为空属性，只对POJO起作用，map或者list无效
//        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        // 是否进行缩进输出
        configure(SerializationFeature.INDENT_OUTPUT, false);

        // 将驼峰转为下划线
        // setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        this.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        this.setTimeZone(TimeZone.getDefault());

        // 进行日期格式化
        String dateFormatPattern = "yyyy-MM-dd HH:mm:ss";
        this.setDateFormat(new SimpleDateFormat(dateFormatPattern));
    }


    public String toJSONString(Object object) {
        try {
            return writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
