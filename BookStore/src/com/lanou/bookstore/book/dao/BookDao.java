package com.lanou.bookstore.book.dao;

import com.lanou.bookstore.book.domain.BookCategory;
import com.lanou.bookstore.datasource.ComboPool;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by : dllo on 18/9/3.
 */
public class BookDao implements IBookDao {
 private ComboPooledDataSource ds = ComboPool.getDataSource();

    @Override
    public int findTotalCount() throws Exception {
        Connection con = ds.getConnection();
        try {
            String sql = "select count(bid) as count from book";
            QueryRunner qr = new QueryRunner();
            Map<String, Object> map = qr.query(con, sql, new MapHandler());
            int count = Integer.parseInt(String.valueOf(map.get("count")));
            return count;
        } finally {
            DbUtils.closeQuietly(con);
        }
    }

    @Override
    public List<BookCategory> findBook() throws SQLException {
        Connection con = ds.getConnection();
        try {
           String sql = "select b.*,c.cname from book as b left join category as c on b.cid = c.cid";
//            String sql = "select * from category";
            QueryRunner qr = new QueryRunner();
            List<BookCategory> list = qr.query(con, sql, new BeanListHandler<>(BookCategory.class, new BasicRowProcessor(new GenerousBeanProcessor())));
            System.out.println(list);
            return list;

        } finally {
            DbUtils.closeQuietly(con);
        }
    }


}
