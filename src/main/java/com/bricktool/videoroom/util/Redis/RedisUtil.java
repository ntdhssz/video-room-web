package com.bricktool.videoroom.util.Redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class RedisUtil {

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    public RedisTemplate<Object, Object> getInstance() {
        return redisTemplate;
    }

    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void setex(String key, Object value, long expireTime) {
        redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void del(String key) {
        redisTemplate.delete(key);
    }
}
