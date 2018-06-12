package com.self.cms.bussiness.service.impl;


import com.self.cms.bussiness.service.UserService;
import com.self.common.persistence.entity.User;
import com.self.common.persistence.mapper.generate.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chengfengfeng
 * @date 2018/6/11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
