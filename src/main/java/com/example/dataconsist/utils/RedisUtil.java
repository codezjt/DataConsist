package com.example.dataconsist.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    public boolean delete(String key){
        return redisTemplate.delete(key);
    }

    public void set(String key, String value){
        set(key, value);
    }

    public void set(String key, String value, Long timeOut){
        redisTemplate.opsForValue().set(key, value);
        if(timeOut != null){
            redisTemplate.expire(key, timeOut, TimeUnit.SECONDS);
        }
    }

    public String get(String key){
        return (String) redisTemplate.opsForValue().get(key);
    }

}
