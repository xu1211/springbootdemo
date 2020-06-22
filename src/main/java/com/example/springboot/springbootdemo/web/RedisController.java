package com.example.springboot.springbootdemo.web;

import com.example.springboot.springbootdemo.bean.User;
import com.example.springboot.springbootdemo.util.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RequestMapping("/redis")
@RestController
public class RedisController {

    private static int ExpireTime = 60; // redis中存储的过期时间60s

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("set")
    public Object redisset(String key, String value) {
        redisUtil.set(key, value);
        return redisUtil.get(key);
    }

    @RequestMapping("get")
    public Object redisget(String key) {
        return redisUtil.get(key);
    }

    @RequestMapping("expire")
    public boolean expire(String key) {
        return redisUtil.expire(key, ExpireTime);
    }
}