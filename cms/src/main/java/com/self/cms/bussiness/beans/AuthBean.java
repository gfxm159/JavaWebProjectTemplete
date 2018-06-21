package com.self.cms.bussiness.beans;

import java.io.Serializable;
import java.util.List;

public class AuthBean implements Serializable {

    private static final long serialVersionUID = 7695368955173459973L;
    private Integer id;
    private String icon;
    private String name;
    private String url;
    private Boolean hasMenu;
    private List<AuthBean> menuList;

    public AuthBean() {
    }

    public AuthBean(Integer id,String icon, String name, String url, Boolean hasMenu, List<AuthBean> menuList) {
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.url = url;
        this.hasMenu = hasMenu;
        this.menuList = menuList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getHasMenu() {
        return hasMenu;
    }

    public void setHasMenu(Boolean hasMenu) {
        this.hasMenu = hasMenu;
    }

    public List<AuthBean> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<AuthBean> menuList) {
        this.menuList = menuList;
    }
}
