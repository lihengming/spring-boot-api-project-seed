package com.company.project.web;

import com.company.project.service.TestRedisCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.RedisClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试redis缓存成功， 使用redisClient进行redis操作
 * @author nickChen
 * create on 2017-10-10 11:34.
 */
@RestController
public class TestRedisCacheController {
    private static final Logger LOG = LoggerFactory.getLogger(TestRedisCacheController.class);

    @Autowired
    private RedisClient redisClient;

    @Autowired
    private TestRedisCacheService testRedisCacheService;

    @GetMapping("/redisCache")
    public String redisCache() {
        redisClient.set("hi", "hi, seed.", 100);
        LOG.info("getRedisValue = {}", redisClient.get("hi"));

        testRedisCacheService.testCache2("aaa", "bbb");
        return testRedisCacheService.testCache();
    }
}
