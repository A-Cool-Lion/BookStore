package com.lanou.bookstore.user.web.servlet;

import com.lanou.bookstore.datasource.ComboPool;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by : dllo on 18/9/5.
 */
@WebServlet(name = "RegisterServlet",urlPatterns = "/user/register")
public class RegisterServlet extends HttpServlet {
    private ComboPooledDataSource ds;
    private QueryRunner qr;


    @Override
    public void init() throws ServletException {
        ds = ComboPool.getDataSource();
        qr = new QueryRunner();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");


        Connection con = null;
        try {
            con = ds.getConnection();
            String sql = "insert into tb_user(username,password,email) value(?, ?, ?)";
            Object[] params = {username,password,email};
            Long id = qr.insert(con, sql, new ScalarHandler<Long>(1), params);

           String result = "注册成功";
           String msg = "秒后跳转到登录页面";
           String path = "/jsps/user/login.jsp";

            req.setAttribute("re",result);
            req.setAttribute("m",msg);
            req.setAttribute("p",path);


            resp.setHeader("Refresh","5,url="+path);
            req.getRequestDispatcher("/jsps/user/register-result.jsp").forward(req,resp);

            DbUtils.closeQuietly(con);

            System.out.println("注册成功");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
