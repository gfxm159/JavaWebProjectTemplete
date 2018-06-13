package com.self.cms.bussiness.service;


/**
 * Created by self on 2018/6/11.
 */
public interface RedisService {

    void  setToRedis(String key,Object object);

    Object getForRedis(String key);
}
