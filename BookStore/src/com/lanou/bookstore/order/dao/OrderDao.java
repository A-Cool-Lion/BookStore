package com.lanou.bookstore.order.dao;

import com.lanou.bookstore.common.ResultWrapper;
import com.lanou.bookstore.order.domain.OrderAllBean;

import java.util.Date;
import java.util.List;

/**
 * Created by : dllo on 18/9/6.
 */
public interface OrderDao<T> {

    List<T> queryOrder() throws Exception;

    Long addOrder(String number, String date, double totalPrice, int status, Long uid, String address) throws Exception;

    void addOrderitem(int bid, int count, double totalPrice, Long oid, String bname, String author, String image, double price) throws Exception;

    List<T> queryOrderItem(int oid) throws Exception;

    void modifyStatus(String onumber, int newStatus) throws Exception;

    void modifyAddress(String onumber, String newAddress) throws Exception;

    List<T> queryAll() throws Exception;

    List<T> queryStatusAll(int status) throws Exception;

    List<T> queryOneOrder(String onumber) throws Exception;
}
