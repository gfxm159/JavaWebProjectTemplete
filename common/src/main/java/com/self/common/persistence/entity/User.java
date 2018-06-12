package com.self.common.persistence.entity;

import com.self.common.persistence.base.BaseEntity;
import javax.persistence.*;

public class User extends BaseEntity {
    @Id
    private Integer id;

    private String username;

    private String password;

    /**
     * 1 已删除 0 未删除
     */
    @Column(name = "is_delete")
    private Integer isDelete;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取1 已删除 0 未删除
     *
     * @return is_delete - 1 已删除 0 未删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置1 已删除 0 未删除
     *
     * @param isDelete 1 已删除 0 未删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}