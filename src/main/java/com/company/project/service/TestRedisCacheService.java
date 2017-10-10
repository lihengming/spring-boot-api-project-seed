package com.company.project.service;

import com.company.project.redis.RedisKeys;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author nickChen
 * create on 2017-10-10 11:29.
 */
@Service
public class TestRedisCacheService {

    /**
     * @Cacheable 的 value 属性等同于 cacheNames，是指定缓存集名称。
     * key 默认是由函数中所有参数组合作为key值，可以自定义key值，包括使用SpEL。
     * keyGenerator 用于指定key生成器，和上面的key属性互斥。CachingConfigurer.java 中设置了新的keyGenerator。
     * @return 这里的缓存时间是RedisKeys.java中设置的默认超时时间20秒。
     */
    @Cacheable(value = RedisKeys._CACHE_TEST, key = "'" + RedisKeys._CACHE_TEST + "'")
    public String testCache() {
        return RandomStringUtils.randomNumeric(4);
    }

    @Cacheable(value = RedisKeys._CACHE_TEST)
    public String testCache2(String s1, String s2) {
        return RandomStringUtils.randomNumeric(4);
    }

}
