package com.self.cms.bussiness.beans;

import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by Mj on 2018/3/12.
 */
public class PageVO<T> {
    private long total;
    private List<T> rows;

    public PageVO(){}

    public PageVO(Page page){
        this.total = page.getTotal();
        this.rows = page.getResult();
    }

    public PageVO(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
