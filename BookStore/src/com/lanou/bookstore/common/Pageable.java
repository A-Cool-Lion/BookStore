package com.lanou.bookstore.common;

import java.util.List;

/**
 * Created by dllo on 18/8/25.
 */
public class Pageable<T> {
    // 数据总数量
    private int totalCount;
//     每页显示的数量
//    private int count;
    // 每页具体的数据
    private List<T> items;


    public Pageable() {
    }

    public Pageable(int totalCount, List<T> items) {
        this.totalCount = totalCount;
        this.items = items;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
