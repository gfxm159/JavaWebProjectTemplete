package com.self.cms.bussiness.service;


import com.self.common.persistence.entity.User;

/**
 * Created by chengfengfeng on 2018/6/11.
 */
public interface UserService {

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    User getUser(int id);
}
