package com.lanou.bookstore.category.admin.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminCategoryFilter", urlPatterns = "/adminjsps/admin/*")
public class AdminCategoryFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {

        // 获取管理员的 session 信息
        HttpSession session = req.getSession();
        Object admin = session.getAttribute("admin");

        // 验证是否已登录
        if (admin != null) {
            chain.doFilter(req, resp);
        } else {
            resp.sendRedirect("/adminjsps/login.jsp");
        }

    }
}
