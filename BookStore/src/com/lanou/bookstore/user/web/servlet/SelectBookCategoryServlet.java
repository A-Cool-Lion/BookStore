package com.lanou.bookstore.user.web.servlet;

import com.google.gson.Gson;
import com.lanou.bookstore.book.domain.BookBean;
import com.lanou.bookstore.common.ResultWrapper;
import com.lanou.bookstore.datasource.ComboPool;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by : dllo on 18/9/5.
 */
@WebServlet(name = "SelectBookCategoryServlet", urlPatterns = "/s/category/book")
public class SelectBookCategoryServlet extends HttpServlet {





    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();

      int cid = Integer.parseInt(req.getParameter("cid"));




            List<BookBean> list = selectBook(cid);
            req.setAttribute("list", list);


            new Gson().toJson(list, out);
            out.close();

    }


    public  List<BookBean> selectBook(int id)  {


        ComboPooledDataSource ds = ComboPool.getDataSource();

        Connection con = null;
        try {
            con = ds.getConnection();
            String sql = "select * from book where cid = ?";
            Object[] params = {id};
            QueryRunner qr = new QueryRunner();
            List<BookBean> list = qr.query(con, sql, new BeanListHandler<>(BookBean.class,
                    new BasicRowProcessor(new GenerousBeanProcessor())), params);

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }






}
