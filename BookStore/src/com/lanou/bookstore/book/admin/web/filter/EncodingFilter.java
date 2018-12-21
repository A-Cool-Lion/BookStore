package com.lanou.bookstore.book.admin.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 继承自己改写的 HttpFilter
// 注册 EncodingFilter
//@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
public class EncodingFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        // 设置请求体中文本的编码格式
        req.setCharacterEncoding("utf-8");

        // 设置响应体中文本的编码格式
        resp.setCharacterEncoding("utf-8");

        // 设置响应头的文本类型 ( 当有其他文本类型时可重新书写此方法以覆盖 )
        resp.setContentType("text/html;charset=utf-8");

        // 需放行前做好转码工作
        chain.doFilter(req, resp);


    }
}
