package com.self.cms.system.config.auth;

import java.io.Serializable;

public class UserDetails implements Serializable {

    private static final long serialVersionUID = -7472067630351911851L;
    private Integer userId;
    private String loginName;

    public UserDetails() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserDetails(Integer userId, String loginName) {
        this.userId = userId;
        this.loginName = loginName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
