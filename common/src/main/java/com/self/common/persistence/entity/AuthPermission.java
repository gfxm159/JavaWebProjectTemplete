package com.self.common.persistence.entity;

import com.self.common.persistence.base.BaseEntity;
import javax.persistence.*;

@Table(name = "auth_permission")
public class AuthPermission extends BaseEntity {
    @Id
    private Integer id;

    private String url;

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
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}