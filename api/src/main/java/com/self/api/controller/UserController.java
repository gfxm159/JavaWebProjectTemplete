package com.self.api.controller;

import com.self.api.support.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ShiXin
 * @date 2018/7/12 17:38
 */
@RestController
@RequestMapping("/v1/user")
public class UserController extends BaseController {

    @RequestMapping("/login")
    public String login(){
        return "hello ";
    }
}
