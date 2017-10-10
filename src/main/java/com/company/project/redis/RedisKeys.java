package com.company.project.redis;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nickChen
 * create on 2017-10-10 11:17.
 */
@Component
public class RedisKeys {
    // 测试 begin
    /**
     * 这里设置了一个默认的 cache name，以及默认的 expire time。
     * 可根据应用自行修改。
     */
    public static final String _CACHE_TEST = "_cache_test";// 缓存key
    public static final Long _CACHE_TEST_SECOND = 20L;// 缓存时间
    // 测试 end

    // 根据key设定具体的缓存时间
    private Map<String, Long> expiresMap = null;

    @PostConstruct
    public void init(){
        expiresMap = new HashMap<>();
        expiresMap.put(_CACHE_TEST, _CACHE_TEST_SECOND);
    }

    public Map<String, Long> getExpiresMap(){
        return this.expiresMap;
    }
}
