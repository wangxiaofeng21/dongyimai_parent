package com.offcn.entity;

import java.io.Serializable;//序列化
import java.util.List;

public class PageResult implements Serializable {

    //本页行数
    private List rows;
    //总条数
    private long total;

    public PageResult() {
    }

    public PageResult(List rows, Long total) {
        this.rows = rows;
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
