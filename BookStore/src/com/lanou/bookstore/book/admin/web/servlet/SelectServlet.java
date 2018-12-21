package com.lanou.bookstore.book.admin.web.servlet;

import com.google.gson.Gson;
import com.lanou.bookstore.book.service.CategoryService;
import com.lanou.bookstore.book.service.IService;
import com.lanou.bookstore.category.dao.CategoryDao;
import com.lanou.bookstore.category.dao.CategoryDaoImpl;
import com.lanou.bookstore.category.domain.CategoryBean;
import com.lanou.bookstore.common.ResultWrapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by : dllo on 18/9/3.
 *
 *  添加图书时下拉选框查询的Servlet
 */
@WebServlet(name = "SelectServlet",urlPatterns = "/select")
public class SelectServlet extends HttpServlet {
    private IService service ;

    @Override
    public void init() throws ServletException {
        service = new CategoryService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        HttpSession session = req.getSession();

        ResultWrapper book = service.findBook();
        PrintWriter out = resp.getWriter();
        new Gson().toJson(book,out);
        out.close();



    }
}
