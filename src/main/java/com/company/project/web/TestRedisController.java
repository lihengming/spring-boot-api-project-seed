package com.company.project.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 使用redisTemplate进行redis操作
 * @author nickChen
 * create on 2017-10-10 11:00.
 */
@RestController
public class TestRedisController {

    private Logger logger = LoggerFactory.getLogger(TestRedisController.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 缓存测试
     *
     * @return
     * @author  SHANHY
     * @create  2016年9月12日
     */
    @RequestMapping("/redisTest")
    public String redisTest() {
        try {
            redisTemplate.opsForValue().set("test-key", "redis测试内容", 2, TimeUnit.SECONDS);// 缓存有效期2秒

            logger.info("从Redis中读取数据：" + redisTemplate.opsForValue().get("test-key").toString());

            TimeUnit.SECONDS.sleep(3);

            logger.info("等待3秒后尝试读取过期的数据：" + redisTemplate.opsForValue().get("test-key"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "OK";
    }
}
