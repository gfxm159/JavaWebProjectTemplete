package com.self.cms.bussiness.service.impl;


import com.alibaba.fastjson.JSON;
import com.self.cms.bussiness.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author chengfengfeng
 * @date 2018/6/11
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void setToRedis(String key, Object object) {
        stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(object));
    }

    @Override
    public Object getForRedis(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
