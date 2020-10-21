package com.antiy.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/1
 */
//@Controller
@Api(tags = "1.1", description = "Reids", value = "Redis测试")
public class RedisController {
    private static final String REDIS_TEST = "test";
    private Logger logger = Logger.getLogger("RedisController");
    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation(value = "redis存储", notes = "传入实体对象信息")
    @RequestMapping(value = "/put")
    @ResponseBody
    public String testRedisAdd(String test) {
        redisTemplate.opsForValue().set(REDIS_TEST, test);
        logger.info("缓存redis");
        return "redis";
    }

    @ApiOperation(value = "redis取值", notes = "传入实体对象信息")
    @RequestMapping(value = "/get")
    @ResponseBody
    public String getRedis() {
        logger.info("获取缓存redis");
        return (String) redisTemplate.opsForValue().get(REDIS_TEST);
    }
}
