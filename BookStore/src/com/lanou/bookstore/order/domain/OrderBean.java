package com.lanou.bookstore.order.domain;

import java.util.Date;

/**
 * Created by : dllo on 18/9/6.
 */
public class OrderBean {
    private int oid;
    private String onumber;
    private String ordertime;
    private double total;
    private int status;
    private Long uid;
    private String address;


    public OrderBean(int oid, String onumber, String ordertime, double total, int status, Long uid, String address) {
        this.oid = oid;
        this.onumber = onumber;
        this.ordertime = ordertime;
        this.total = total;
        this.status = status;
        this.uid = uid;
        this.address = address;
    }


    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getOnumber() {
        return onumber;
    }

    public void setOnumber(String onumber) {
        this.onumber = onumber;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
