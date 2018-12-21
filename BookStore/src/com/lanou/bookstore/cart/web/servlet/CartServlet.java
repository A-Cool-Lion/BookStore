package com.lanou.bookstore.cart.web.servlet;

import com.lanou.bookstore.cart.Cart;
import com.lanou.bookstore.cart.domain.CartItem;
import com.lanou.bookstore.common.MathFormat;
import com.mchange.v2.collection.MapEntry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@WebServlet(name = "CartServlet", urlPatterns = "/cart/*")
public class CartServlet extends HttpServlet {

//    private Cart cart = new Cart(); // 假

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();
        String substring = uri.substring(uri.indexOf('/', 3) + 1, uri.length());
        System.out.println(substring);

        Class<? extends CartServlet> clazz = this.getClass();
        try {
            Method method = clazz.getDeclaredMethod(substring, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 取出相关数据


        String bookImage = req.getParameter("bookImage");
        int amount = Integer.parseInt(req.getParameter("amount"));
        String bookId = req.getParameter("bookId");
        String bookName = req.getParameter("bookName");
        String bookAuthor = req.getParameter("bookAuthor");
        Float bookPrice = Float.parseFloat(req.getParameter("bookPrice"));
        bookPrice = MathFormat.formatFloat(bookPrice);
        // 计算出价格 = 数量 * 单价
        double totalPrice = amount * bookPrice;
        totalPrice = MathFormat.formatDouble(totalPrice);

        System.out.printf("%s, %s, %s, %s, %s, %s", bookImage, amount, bookId, bookName, bookAuthor, bookPrice);



        // 从 session 中取出车
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        Map<String, CartItem> map = cart.getMap();
        CartItem item = map.get(bookId);
        if (item == null) {
            CartItem cartItem = new CartItem(bookImage, bookId, bookName, bookAuthor, bookPrice, amount, totalPrice);
            map.put(bookId, cartItem);
        } else {
            item.setAmount(amount + item.getAmount());
            item.setTotalPrice(totalPrice + item.getTotalPrice());
        }

        session.setAttribute("cart", cart);

        resp.sendRedirect("/jsps/cart/list.jsp");

    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        String bookId = req.getParameter("key");
        System.out.println("key为: " + bookId);
        Map<String, CartItem> map = cart.getMap();
        map.remove(bookId);
        resp.sendRedirect("/jsps/cart/list.jsp");

    }

    public void empty(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Map<String, CartItem> map = cart.getMap();
        map.clear();
        resp.sendRedirect("/jsps/cart/list.jsp");

    }





}
