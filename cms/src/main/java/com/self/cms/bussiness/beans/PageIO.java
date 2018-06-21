package com.self.cms.bussiness.beans;


import javax.validation.constraints.NotNull;

public class PageIO {
    /**
     * 页码
     */
    @NotNull
    private Integer page = 1;
    /**
     * 查询条数
     */
    @NotNull
    private Integer rows = 10;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
