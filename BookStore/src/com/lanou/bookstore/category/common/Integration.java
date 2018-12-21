package com.lanou.bookstore.category.common;

import java.util.List;

public class Integration<T> {

    private int totalCount;
    private List<T> beanList;

    public Integration() {
    }

    public Integration(int totalCount, List<T> beanList) {
        this.totalCount = totalCount;
        this.beanList = beanList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }
}
