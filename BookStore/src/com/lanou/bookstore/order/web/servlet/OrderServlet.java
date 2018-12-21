package com.lanou.bookstore.order.web.servlet;

import com.google.gson.Gson;
import com.lanou.bookstore.cart.Cart;
import com.lanou.bookstore.cart.domain.CartItem;
import com.lanou.bookstore.common.MathFormat;
import com.lanou.bookstore.order.dao.OrderDao;
import com.lanou.bookstore.order.dao.OrderDaoImpl;
import com.lanou.bookstore.order.domain.OrderAllBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

@WebServlet(name = "OrderServlet", urlPatterns = "/order/*")
public class OrderServlet extends HttpServlet {
    private OrderDao orderDao;

    @Override
    public void init() throws ServletException {
        orderDao = new OrderDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String substring = uri.substring(uri.indexOf("/", 3) + 1, uri.length());
        System.out.println(substring);

        Class<? extends OrderServlet> clazz = this.getClass();
        try {
            Method method = clazz.getDeclaredMethod(substring, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        // 获得车(所有货物)
        Cart cart = (Cart) session.getAttribute("cart");

        // 获得总价
        double finalPrice = (double) session.getAttribute("finalPrice");
        finalPrice = MathFormat.formatDouble(finalPrice);

        // 获得用户名字
        int userId = (int) session.getAttribute("userid");
        System.out.println("用户id: " + userId);

        // 生成订单号 -> 9位随机数
        int orderNo = new Random().nextInt(999999999);
        if (orderNo < 100000000) {
            orderNo += 100000000;
        }
        session.setAttribute("orderNo", orderNo);
        System.out.println(orderNo);

        // 生成成交时间
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");//设置日期格式
        String nowDate = LocalDateTime.now().format(fmt);


        session.setAttribute("orderTime", nowDate);
        System.out.println("成交时间：" + nowDate);

        String address = req.getParameter("address");

        // TODO MRD
        // TODO orderNo nowDate finalPrice status:0 userId userAddress
        // TODO bookId amount totalCount

        try {
            Long oid = orderDao.addOrder(String.valueOf(orderNo), nowDate, finalPrice, 1, (long) userId, address);


            Map<String, CartItem> map = cart.getMap();
            Set<Map.Entry<String, CartItem>> entries = map.entrySet();
            for (Map.Entry<String, CartItem> entry : entries) {

                String bookName = entry.getValue().getBookName();
                String bookId = entry.getValue().getBookId();
                int amount = entry.getValue().getAmount();
                double totalPrice = entry.getValue().getTotalPrice();
                totalPrice = MathFormat.formatDouble(totalPrice);
                String bookAuthor = entry.getValue().getBookAuthor();
                String bookImage = entry.getValue().getBookImage();
                Float bookPrice = entry.getValue().getBookPrice();

                orderDao.addOrderitem(Integer.parseInt(bookId), amount, totalPrice, oid, bookName,bookAuthor,bookImage,bookPrice);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        resp.sendRedirect("/jsps/order/desc.jsp");

    }

    public void payment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String orderNo = String.valueOf(session.getAttribute("orderNo"));
        Cart cart = (Cart) session.getAttribute("cart");
        // 结算时清除购物车
        cart.getMap().clear();

        String address = req.getParameter("address");
        String bankId = req.getParameter("pd_FrpId");


        try {
            orderDao.modifyStatus(orderNo, 2);
            orderDao.modifyAddress(orderNo, address);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        resp.sendRedirect("/jsps/order/list.jsp");
         resp.sendRedirect("/jsps/main.jsp");
    }

    public void getJson(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.setContentType("application/json;charset=utf-8");

        PrintWriter out = resp.getWriter();

        List list = null;

        String status = req.getParameter("status");
        int i = 0;
        if (status != null) {
             i = Integer.parseInt(status);
        } else {
             list = orderDao.queryAll();
        }




        if (i == 0 ){
             list = orderDao.queryAll();
        }

        else{
             list = orderDao.queryStatusAll(i);
        }
        new Gson().toJson(list,out);
        out.close();

    }
// 管理员发货修改状态
    public void modifyState(HttpServletRequest req,HttpServletResponse resp) throws Exception {
        resp.setContentType("text/html;charset=utf-8");

        String onumber = req.getParameter("No");
        int status = Integer.parseInt(req.getParameter("status"));
        orderDao.modifyStatus(onumber,status);

        req.getRequestDispatcher("/adminjsps/admin/order/list.jsp").forward(req,resp);

    }

    // 用户改状态
    public void changeState(HttpServletRequest req,HttpServletResponse resp) throws Exception {
        resp.setContentType("text/html;charset=utf-8");

        String onumber = req.getParameter("No");
        int status = Integer.parseInt(req.getParameter("status"));
        orderDao.modifyStatus(onumber,status);

        req.getRequestDispatcher("/jsps/order/list.jsp").forward(req,resp);

    }

    // 重新付款
    public void repay(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        System.out.println("OrderServlet.pay");

        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Map<String, CartItem> map = cart.getMap();
        map.clear();

        String onumber = req.getParameter("No");
        List<OrderAllBean> list = orderDao.queryOneOrder(onumber);
        for (OrderAllBean data : list) {
            map.put(String.valueOf(data.getBid()), new CartItem(
                    data.getImage(),
                    String.valueOf(data.getBid()),
                    data.getBname(),
                    data.getAuthor(),
                    (float) data.getPrice(),
                    data.getCount(),
                    data.getSubtotal()
            ));
            session.setAttribute("orderNo", data.getOnumber());
            session.setAttribute("orderTime", data.getOrdertime());
            session.setAttribute("finalPrice", data.getTotal());
        }
        cart.setMap(map);
        session.setAttribute("cart", cart);

        req.getRequestDispatcher("/jsps/order/desc.jsp").forward(req, resp);

    }



}
