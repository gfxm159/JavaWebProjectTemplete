package com.self.cms.system.config.auth;

import java.io.Serializable;

public class UserDetails implements Serializable {

    private static final long serialVersionUID = -7472067630351911851L;
    private String loginName;

    public UserDetails() {
    }

    public UserDetails(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
