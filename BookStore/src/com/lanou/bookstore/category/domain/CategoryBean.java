package com.lanou.bookstore.category.domain;

public class CategoryBean {

    private int cId;
    private String cName;

    public CategoryBean() {
    }

    public CategoryBean(int cId, String cName) {
        this.cId = cId;
        this.cName = cName;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
}
