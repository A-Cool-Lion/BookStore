package com.lanou.bookstore.cart.domain;

import com.lanou.bookstore.common.MathFormat;

import java.util.List;

public class CartItem {

    private String bookImage;
    private String bookId;
    private String bookName;
    private String bookAuthor;
    private Float bookPrice;
    private int amount;
    private double totalPrice;


    public CartItem() {
    }

    public CartItem(String bookImage, String bookId, String bookName, String bookAuthor, Float bookPrice, int amount, double totalPrice) {
        this.bookImage = bookImage;
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.amount = amount;
        totalPrice = MathFormat.formatDouble(totalPrice);
        this.totalPrice = totalPrice;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        totalPrice = MathFormat.formatDouble(totalPrice);
        this.totalPrice = totalPrice;
    }
}
