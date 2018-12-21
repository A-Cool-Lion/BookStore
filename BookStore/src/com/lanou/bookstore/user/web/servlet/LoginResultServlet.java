package com.lanou.bookstore.user.web.servlet;

import com.lanou.bookstore.category.dao.CategoryDao;
import com.lanou.bookstore.category.dao.CategoryDaoImpl;
import com.lanou.bookstore.category.domain.CategoryBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by : dllo on 18/9/5.
 */
@WebServlet(name = "LoginResultServlet",urlPatterns = "/user/login-result")
public class LoginResultServlet extends HttpServlet {
    private CategoryDao categoryDao;


    private static final String l_result = "result";
    private static final String l_msg = "message";
    private static final String l_path = "path";

    @Override
    public void init() throws ServletException {
        categoryDao = new CategoryDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("html/text;charset=utf-8");

        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");
       String path = null;
       String result = null;
        String msg = null;
        if (user != null){
            result = "登录成功";
            msg = "秒后跳转到LanOu书城";
            path = "/jsps/main.jsp";


            try {
                List<CategoryBean> categoryList = categoryDao.queryBookName();
                session.setAttribute("categorylist",categoryList);
            } catch (Exception e) {
                e.printStackTrace();
            }



        } else{
           result = "登录失败";
            msg = "秒后跳回到登录页面";
            path = "/jsps/user/login.jsp";
        }
        session.setAttribute(l_result,result);
        session.setAttribute(l_msg,msg);
        session.setAttribute(l_path,path);

        resp.setHeader("Refresh","5,url=" + path);

        req.getRequestDispatcher("/jsps/user/login-result.jsp").forward(req,resp);



    }
    }

