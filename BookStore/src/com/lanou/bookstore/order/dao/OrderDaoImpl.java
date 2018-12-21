package com.lanou.bookstore.order.dao;

import com.lanou.bookstore.datasource.ComboPool;
import com.lanou.bookstore.order.domain.OrderAllBean;
import com.lanou.bookstore.order.domain.OrderBean;
import com.lanou.bookstore.order.domain.OrderItemBean;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by : dllo on 18/9/6.
 */
public class OrderDaoImpl implements OrderDao {
    private ComboPooledDataSource ds = ComboPool.getDataSource();
    private Connection con;
    private QueryRunner qr;

    public OrderDaoImpl()  {
        try {
             con = ds.getConnection();
            qr = new QueryRunner();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderBean> queryOrder() throws Exception {
        String sql = "select * from orders";
        List<OrderBean> list = qr.query(con, sql, new BeanListHandler<>(OrderBean.class, new BasicRowProcessor(new GenerousBeanProcessor())));
        System.out.println("查询了订单表");
        return list;
    }

    @Override
    public Long addOrder(String number, String date, double totalPrice, int status, Long uid, String address) throws Exception {
        String sql = "insert into orders(onumber,ordertime,total,status,uid,address) value(?, ?, ?, ?, ?, ?)";
        Object[] params={number,date,totalPrice,status,uid,address};
        Long i = qr.insert(con, sql,new ScalarHandler<Long>(1),params);
        System.out.println("插入订单表"+i+"条数据成功!");
        return i;
    }

    @Override
    public void addOrderitem(int bid,int count,double totalPrice,Long oid,String bname,String author,String image,double price) throws Exception {
       String sql = "insert into orderitem(bid,count,subtotal,oid,bname,author,image,price) value (?, ?, ?, ?, ?, ?, ?, ?)";
       Object[] params = {bid,count,totalPrice,oid,bname,author,image,price};
        qr.update(con, sql, params);
        System.out.println("插入订单项表,,订单项表1条数据成功");
    }

    @Override
    public List<OrderItemBean> queryOrderItem(int oid) throws Exception {
        String sql = "select * from orderitem where oid = ?";
        Object[] params = {oid};
        List<OrderItemBean> list = qr.query(con, sql, new BeanListHandler<>(OrderItemBean.class, new BasicRowProcessor(new GenerousBeanProcessor())));
        System.out.println("查询了订单项表");
        return list;
    }

    @Override
    public void modifyStatus(String onumber, int newStatus) throws Exception {
        String sql = "update orders set status = ? where onumber = ?";
        Object[] params = {newStatus,onumber};
        qr.update(con,sql,params);
        System.out.println("修改状态"+newStatus+"成功!");
    }

    @Override
    public void modifyAddress(String onumber, String newAddress) throws Exception {
        String sql = "update orders set address = ? where onumber = ?";
        Object[] params = {newAddress,onumber};
        qr.update(con,sql,params);
        System.out.println("修改地址"+newAddress+"成功!");
    }

    @Override
    public List<OrderAllBean> queryAll() throws Exception {
        String sql = "select o1.ordertime,o1.total,o1.status,o1.uid,o1.onumber,o2.* from orders as o1 right join orderitem as o2 on o1.oid = o2.oid";
        List<OrderAllBean> list = qr.query(con, sql, new BeanListHandler<>(OrderAllBean.class, new BasicRowProcessor(new GenerousBeanProcessor())));
        return list;

    }

    @Override
    public List<OrderAllBean> queryStatusAll(int status) throws Exception {
        String sql = "select o1.ordertime,o1.total,o1.status,o1.uid,o1.onumber,o2.* from orders as o1 right join orderitem as o2 on o1.oid = o2.oid where o1.status = ?";
        List<OrderAllBean> list = qr.query(con, sql, new BeanListHandler<>(OrderAllBean.class, new BasicRowProcessor(new GenerousBeanProcessor())),status);
        return list;

    }

    // 查询一个订单下的所有数据
    @Override
    public List<OrderAllBean> queryOneOrder(String onumber) throws Exception {
        String sql = "select o1.ordertime,o1.total,o1.status,o1.uid,o1.onumber,o2.* from orders as o1 right join orderitem as o2 on o1.oid = o2.oid where o1.onumber = ?";
        List<OrderAllBean> list = qr.query(con, sql, new BeanListHandler<>(OrderAllBean.class, new BasicRowProcessor(new GenerousBeanProcessor())),onumber);
        return list;
    }


}
