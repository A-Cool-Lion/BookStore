package com.lanou.bookstore.order.domain;

import com.lanou.bookstore.common.MathFormat;

import java.util.Date;

/**
 * Created by : dllo on 18/9/7.
 */
public class OrderAllBean {
//    private String ordertime;
//    private double total;
//    private int status;
//    private long uid;
//    private String onumber;
//    private int iid;
//    private int count;
//    private double subtotal;
//    private long oid;
//    private int bid;
//    private String bname;
//    private String author;
//    private String image;
//    private double price;

//    public OrderAllBean(String ordertime, double total, int status, long uid, String onumber, int iid, int count, double subtotal, long oid, int bid, String bname, String author, String image, double price) {
//        this.ordertime = ordertime;
//        this.total = total;
//        this.status = status;
//        this.uid = uid;
//        this.onumber = onumber;
//        this.iid = iid;
//        this.count = count;
//        this.subtotal = subtotal;
//        this.oid = oid;
//        this.bid = bid;
//        this.bname = bname;
//        this.author = author;
//        this.image = image;
//        this.price = price;
//    }
//
//    public String getOrdertime() {
//        return ordertime;
//    }
//
//    public void setOrdertime(String ordertime) {
//        this.ordertime = ordertime;
//    }
//
//    public double getTotal() {
//        return total;
//    }
//
//    public void setTotal(double total) {
//        this.total = total;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public long getUid() {
//        return uid;
//    }
//
//    public void setUid(long uid) {
//        this.uid = uid;
//    }
//
//    public String getOnumber() {
//        return onumber;
//    }
//
//    public void setOnumber(String onumber) {
//        this.onumber = onumber;
//    }
//
//    public int getIid() {
//        return iid;
//    }
//
//    public void setIid(int iid) {
//        this.iid = iid;
//    }
//
//    public int getCount() {
//        return count;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }
//
//    public double getSubtotal() {
//        return subtotal;
//    }
//
//    public void setSubtotal(double subtotal) {
//        this.subtotal = subtotal;
//    }
//
//    public long getOid() {
//        return oid;
//    }
//
//    public void setOid(long oid) {
//        this.oid = oid;
//    }
//
//    public int getBid() {
//        return bid;
//    }
//
//    public void setBid(int bid) {
//        this.bid = bid;
//    }
//
//    public String getBname() {
//        return bname;
//    }
//
//    public void setBname(String bname) {
//        this.bname = bname;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }

    private int oid;
    private String ordertime;
    private double total;
    private int status;
    private int uid;
    private String onumber;
    private int iid;
    private int count;
    private double subtotal;
    private int bid;
    private String bname;
    private String author;
    private String image;
    private double price;

    public OrderAllBean() {
    }

    public OrderAllBean(int oid, String ordertime, double total, int status, int uid, String onumber, int iid, int count, double subtotal, int bid, String bname, String author, String image, double price) {
        this.oid = oid;
        this.ordertime = ordertime;
        total = MathFormat.formatDouble(total);
        this.total = total;
        this.status = status;
        this.uid = uid;
        this.onumber = onumber;
        this.iid = iid;
        this.count = count;
        subtotal = MathFormat.formatDouble(subtotal);
        this.subtotal = subtotal;
        this.bid = bid;
        this.bname = bname;
        this.author = author;
        this.image = image;
        price = MathFormat.formatDouble(price);
        this.price = price;
    }


    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
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
        total = total = MathFormat.formatDouble(total);
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getOnumber() {
        return onumber;
    }

    public void setOnumber(String onumber) {
        this.onumber = onumber;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSubtotal() {
        subtotal = MathFormat.formatDouble(subtotal);
        return subtotal;
    }
    public void setSubtotal(double subtotal) {
        subtotal = MathFormat.formatDouble(subtotal);
        this.subtotal = subtotal;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        price = MathFormat.formatDouble(price);
        return price;
    }

    public void setPrice(double price) {
        price = MathFormat.formatDouble(price);
        this.price = price;
    }
}
