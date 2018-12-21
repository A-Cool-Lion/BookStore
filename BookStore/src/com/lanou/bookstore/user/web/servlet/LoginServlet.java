package com.lanou.bookstore.user.web.servlet;

import com.lanou.bookstore.cart.Cart;
import com.lanou.bookstore.datasource.ComboPool;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by : dllo on 18/9/5.
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/user/login")
public class LoginServlet extends HttpServlet{
    private ComboPooledDataSource ds;
    private QueryRunner qr;

     private static final String user = "user";

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

        HttpSession session = req.getSession();

        Connection con = null;
        try {
         con = ds.getConnection();
            String sql = "select password,uid from tb_user where username = ?";
            Map<String, Object> map = qr.query(con, sql, new MapHandler(), username);
            Object pass= map.get("password");
            int uid= (int) map.get("uid");
            session.setAttribute("userid",uid);
            System.out.println(pass);
            if (password.equals(pass)){
                Cart cart = new Cart();
                session.setAttribute("cart", cart);
                session.setAttribute(user,username);
                Cookie cookie = new Cookie("JSESSIONID",session.getId());
                cookie.setMaxAge(30 * 60);
                session.setMaxInactiveInterval(40 * 60);
                resp.addCookie(cookie);
            } else{
                session.removeAttribute("user");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (NullPointerException e){
            session.setAttribute("error","用户名不存在!!!");

        }
        finally {

          resp.sendRedirect("/user/login-result");

            DbUtils.closeQuietly(con);
        }


    }

}
