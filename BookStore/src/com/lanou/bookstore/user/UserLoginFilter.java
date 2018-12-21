package com.lanou.bookstore.user;

import com.lanou.bookstore.book.admin.web.filter.HttpFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by : dllo on 18/9/5.
 */
@WebFilter(filterName = "UserLoginFilter",urlPatterns = "/jsps/main.jsp")
public class UserLoginFilter extends HttpFilter{
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");
        boolean isLogin = user != null;
        if (isLogin){
            chain.doFilter(req,resp);
        } else{
            out.write("你还没有登录,2秒后跳转到登录页面");
            resp.setHeader("Refresh","2,url=/jsps/user/login.jsp");
        }


    }
}
