package com.company.project.configurer;

import com.company.project.redis.RedisKeys;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nickChen
 *         create on 2017-10-10 11:18.
 */
@Configuration
@EnableCaching
public class CachingConfigurer extends CachingConfigurerSupport {
    @Override
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb =new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(".").append(method.getName());

                StringBuilder paramsb = new StringBuilder();
                for (Object param : params) {
                    if (param!=null) {
                        paramsb.append(param.toString());
                    }
                }

                if (paramsb.length() > 0) {
                    sb.append("_").append(paramsb);
                }
                return sb.toString();
            }
        };
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate<String, Object> redisTemplate, RedisKeys redisKeys) {
        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
        rcm.setDefaultExpiration(1800); // 30 min

        rcm.setExpires(redisKeys.getExpiresMap());
        List<String> cacheNames = new ArrayList<>(redisKeys.getExpiresMap().keySet());
        rcm.setCacheNames(cacheNames);
        return rcm;
    }
}
