package com.antiy.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Resource
    private RedisTemplate redisTemplate;

    private final static Logger log = LoggerFactory.getLogger("Test");

    @Test
    public void contextLoads() {
    }

    @Test
    public void testRedis() {
        String test = "这个是测试";
        redisTemplate.opsForValue().set("test", test);
        log.info("开始");
        String value = (String) redisTemplate.opsForValue().get("test");
        System.out.println(value);
        log.info("结束");
    }

}
