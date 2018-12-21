package com.lanou.bookstore.category.common;

import java.util.List;

/**
 * 书籍分类结果包装类
 */
public class ResultWrapper<T> {

    private int status;
    private String message;
    private Integration data;



    public ResultWrapper() {
    }

    public ResultWrapper(int status, String message, Integration data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }



    public static ResultWrapper success(Integration data) {
        return new ResultWrapper(200, "OK", data);
    }

    public static <T> ResultWrapper success(int total, List<T> beanList) {
        Integration<T> i = new Integration<>(total, beanList);
        return success(i);
    }

    public static ResultWrapper error(int status, String message) {
        return new ResultWrapper(status, message, null);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integration getData() {
        return data;
    }

    public void setData(Integration data) {
        this.data = data;
    }
}
