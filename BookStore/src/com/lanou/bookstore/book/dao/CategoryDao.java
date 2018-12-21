package com.lanou.bookstore.book.dao;

import com.lanou.bookstore.book.domain.CategoryBean;
import com.lanou.bookstore.datasource.ComboPool;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.DbUtils;
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
public class CategoryDao implements IBookDao {
private ComboPooledDataSource ds = ComboPool.getDataSource();

    @Override
    public int findTotalCount() throws Exception {
        Connection conn = ds.getConnection();

        try {
            String sql = "SELECT COUNT(cid) AS count FROM category";
            QueryRunner runner = new QueryRunner();
            Map<String, Object> map = runner.query(conn, sql, new MapHandler());
            int count = Integer.parseInt(String.valueOf(map.get("count")));
            return count;
        } finally {
            DbUtils.closeQuietly(conn);
        }

    }

    @Override
    public List<CategoryBean> findBook() throws SQLException {
        Connection conn = ds.getConnection();
        try {
            String sql = "SELECT * FROM category";
            QueryRunner runner = new QueryRunner();
            List<CategoryBean> categoryBeanList = runner.query(conn, sql, new BeanListHandler<>(CategoryBean.class, new BasicRowProcessor()));
            return categoryBeanList;
        } finally {
            DbUtils.closeQuietly(conn);
        }

    }
}
