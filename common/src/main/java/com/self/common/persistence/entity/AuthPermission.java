package com.self.common.persistence.entity;

import com.self.common.persistence.base.BaseEntity;
import javax.persistence.*;

@Table(name = "auth_permission")
public class AuthPermission extends BaseEntity {
    @Id
    private Integer id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 接口URL
     */
    private String url;

    /**
     * 具体权限，建议使用英文，shiro中使用@RequiresPermission注解的值与此对应
     */
    private String permission;

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
     * 获取权限名称
     *
     * @return name - 权限名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置权限名称
     *
     * @param name 权限名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取接口URL
     *
     * @return url - 接口URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置接口URL
     *
     * @param url 接口URL
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取具体权限，建议使用英文，shiro中使用@RequiresPermission注解的值与此对应
     *
     * @return permission - 具体权限，建议使用英文，shiro中使用@RequiresPermission注解的值与此对应
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置具体权限，建议使用英文，shiro中使用@RequiresPermission注解的值与此对应
     *
     * @param permission 具体权限，建议使用英文，shiro中使用@RequiresPermission注解的值与此对应
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }
}