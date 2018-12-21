package com.lanou.bookstore.category.dao;

import com.lanou.bookstore.category.domain.CategoryBean;
import com.lanou.bookstore.datasource.ComboPool;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * 查询图书分类总接口实现类
 * 实现方法:
 *     1. 查询出数据库中图书分类总条目数
 *     2. 查询出数据库中分类名称集合 List<CategoryBean>
 */
public class CategoryDaoImpl implements CategoryDao {

    // c3p0 连接池
    ComboPooledDataSource ds = ComboPool.getDataSource();



    @Override
    public int queryTotalCount() throws Exception {
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
    public List<CategoryBean> queryBookName() throws Exception {
        Connection conn = ds.getConnection();
        try {
            String sql = "SELECT * FROM category";
            QueryRunner runner = new QueryRunner();

            List<CategoryBean> categoryBeanList = runner.query(conn, sql, new BeanListHandler<>(CategoryBean.class, new BasicRowProcessor(new GenerousBeanProcessor())));
            return categoryBeanList;
        } finally {
            DbUtils.closeQuietly(conn);
        }

    }

    public int addCategory(String categoryName) throws Exception {
        Connection conn = ds.getConnection();

        try {
            String sql = "INSERT INTO category(cname) VALUES (?)";
            QueryRunner runner = new QueryRunner();
            Object[] params = {categoryName};
            int update = runner.update(conn, sql, params);
            return update;

        } finally {
            DbUtils.closeQuietly(conn);
        }

    }

    @Override
    public int delCategory(String categoryName) throws Exception {
        Connection conn = ds.getConnection();

        try {
            String sql = "DELETE FROM category WHERE cname = ?";
            QueryRunner runner = new QueryRunner();
            Object[] params = {categoryName};
            int update = runner.execute(conn, sql, params);
            return update;
        } finally {
            DbUtils.closeQuietly(conn);
        }

    }

    @Override
    public int modCategory(String oldName, String newName) throws Exception {
        Connection conn = ds.getConnection();
        try {
            String sql = "UPDATE category SET cname = ? WHERE cname = ?";
            QueryRunner runner = new QueryRunner();
            Object[] params = {newName, oldName};
            int update = runner.update(conn, sql, params);
            return update;

        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    @Override
    public int addBook(String bookName, float price, String author, String uuid, int cid) throws Exception {
        Connection conn = ds.getConnection();
        try {
            String sql = "INSERT INTO book(bname,price,author,image,cid) value(?, ?, ?, ?, ?)";
            QueryRunner runner = new QueryRunner();
            Object[] params = {bookName, price, author, uuid, cid};
            int update = runner.update(conn, sql, params);
            return update;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    @Override
    public int delBook(String bookName) throws Exception {
        Connection conn = ds.getConnection();
        try {
            String sql = "DELETE FROM book WHERE bname = ?";
            QueryRunner runner = new QueryRunner();
            Object[] params = {bookName};
            int update = runner.update(conn, sql, params);
            return update;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    @Override
    public int modBook(String bookName, String newName, float newPrice, String newAuthor, int newCid) throws Exception {
        Connection conn = ds.getConnection();
        try {
            String sql = "UPDATE book SET bname = ?, price = ?, author = ?, cid = ? WHERE bname = ?";
            QueryRunner runner = new QueryRunner();
            Object[] params = {newName, newPrice, newAuthor, newCid, bookName};
            int update = runner.update(conn, sql, params);
            return update;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }


}
