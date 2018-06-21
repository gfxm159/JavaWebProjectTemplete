package com.self.common.persistence.entity;

import com.self.common.persistence.base.BaseEntity;
import javax.persistence.*;

@Table(name = "auth_permission")
public class AuthPermission extends BaseEntity {
    @Id
    private Integer id;

    /**
     * 菜单名称
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
     * 父级ID
     */
    @Column(name = "p_id")
    private Integer pId;

    /**
     * 0标签 1权限
     */
    private Integer flag;

    private String icon;

    /**
     * 权重，决定菜单列表的排序
     */
    private Integer weight;

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
     * 获取菜单名称
     *
     * @return name - 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名称
     *
     * @param name 菜单名称
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

    /**
     * 获取父级ID
     *
     * @return p_id - 父级ID
     */
    public Integer getpId() {
        return pId;
    }

    /**
     * 设置父级ID
     *
     * @param pId 父级ID
     */
    public void setpId(Integer pId) {
        this.pId = pId;
    }

    /**
     * 获取0标签 1权限
     *
     * @return flag - 0标签 1权限
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * 设置0标签 1权限
     *
     * @param flag 0标签 1权限
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * @return icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取权重，决定菜单列表的排序
     *
     * @return weight - 权重，决定菜单列表的排序
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置权重，决定菜单列表的排序
     *
     * @param weight 权重，决定菜单列表的排序
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}