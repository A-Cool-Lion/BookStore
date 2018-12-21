package com.lanou.bookstore.category.admin.web.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 为方便使用, 自己创建一个过滤器的基类
 *  1. init 和 destroy 两个方法可以根据需要重写
 *  2. 让 doFilter 参数支持 http 协议
 * */
public abstract class HttpFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 将 ServletRequest 强转为 HttpServletRequest
        // 将 ServletResponse 强转为 HttpServletResponse
        // 调用自己重载的 doFilter 方法
        doFilter((HttpServletRequest) request, (HttpServletResponse) response, chain);
    }

    // 重载 doFilter
    public abstract void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException;

    @Override
    public void destroy() {

    }
}
