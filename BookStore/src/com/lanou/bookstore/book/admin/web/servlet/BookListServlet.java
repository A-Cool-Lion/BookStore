package com.lanou.bookstore.book.admin.web.servlet;

import com.google.gson.Gson;
import com.lanou.bookstore.book.service.BookService;
import com.lanou.bookstore.book.service.IService;
import com.lanou.bookstore.common.ResultWrapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by : dllo on 18/9/3.
 */
@WebServlet(name = "BookListServlet",urlPatterns = "/book/list")
public class BookListServlet extends HttpServlet {
    private IService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json;charset=utf-8");

        ResultWrapper result = bookService.findBook();
        System.out.println("1-------"+result);
        PrintWriter pr = resp.getWriter();
        new Gson().toJson(result,pr);
        pr.close();



    }
}
