package com.lanou.bookstore.order.domain;

/**
 * Created by : dllo on 18/9/6.
 */
public class OrderItemBean {
    private int iid;
    private int bid;
    private int count;
    private double subtotal;
    private Long oid;
    private String bname;
    private String author;
    private String image;
    private double price;

    public OrderItemBean(int iid, int bid, int count, double subtotal, Long oid, String bname, String author, String image, double price) {
        this.iid = iid;
        this.bid = bid;
        this.count = count;
        this.subtotal = subtotal;
        this.oid = oid;
        this.bname = bname;
        this.author = author;
        this.image = image;
        this.price = price;
    }


    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
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
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
