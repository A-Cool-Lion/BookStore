package com.lanou.bookstore.category.admin.web.servlet;

import com.google.gson.Gson;
import com.lanou.bookstore.book.domain.BookImageBean;
import com.lanou.bookstore.category.common.ResultWrapper;
import com.lanou.bookstore.category.service.CategoryService;
import com.lanou.bookstore.category.service.ICategoryService;
import com.lanou.bookstore.datasource.ComboPool;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "AdminCategoryServlet", urlPatterns = "/admin/category/*")
public class AdminCategoryServlet extends HttpServlet {

    private ICategoryService iCategoryService;
    private static final String message = "message";

    @Override
    public void init() throws ServletException {
        iCategoryService = new CategoryService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();
        String substring = uri.substring(uri.indexOf('/', 8) + 1, uri.length());

        Class<? extends AdminCategoryServlet> clazz = this.getClass();
        try {
            Method method = clazz.getDeclaredMethod(substring, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void getJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* --------- 查看分类(json) --------- */
        resp.setContentType("application/json;charset=utf-8");

        ResultWrapper result = iCategoryService.searchCategory();
        PrintWriter out = resp.getWriter();
        new Gson().toJson(result, out);
        out.close();
    }


    private void addCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AdminCategoryServlet.addCategory");

        String cName = req.getParameter("cname");
        int i = iCategoryService.addCategory(cName);
        System.out.println(i);
        resp.sendRedirect("/adminjsps/admin/category/list.jsp");

    }

    private void delCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AdminCategoryServlet.delCategory");

        String cName = req.getParameter("cname");
        int i = iCategoryService.delCategory(cName);
        System.out.println(i);
        resp.sendRedirect("/adminjsps/admin/category/list.jsp");

    }

    private void modCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AdminCategoryServlet.change");

        String newName = req.getParameter("cname");
        String oldName = req.getParameter("ocname");
        int i = iCategoryService.changeCategory(oldName, newName);
        System.out.println(i);
        resp.sendRedirect("/adminjsps/admin/category/list.jsp");
    }

    private void addBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AdminCategoryServlet.addBook");
//        req.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=utf-8");

        ServletContext ctx = getServletContext();
        String realPath = ctx.getRealPath("book-image");
        FileUtils.forceMkdir(new File(realPath));

        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload up = new ServletFileUpload(factory);
        up.setHeaderEncoding("utf-8");
        up.setFileSizeMax(2 * 1024 * 1024);
        up.setSizeMax(5 * 1024 * 1024);

//        ComboPooledDataSource ds = ComboPool.getDataSource();
//        Connection con = null;
        File image = null;
        String msg = null;

        try {
//            con = ds.getConnection();
            List<FileItem> fileItems = up.parseRequest(req);
            BookImageBean bookImage = new BookImageBean();
            Map<String,String> map = new HashMap<>();
            for (FileItem item : fileItems) {
                if (item.isFormField()){
                    String key = item.getFieldName();
                    String value = item.getString("utf-8");
                    map.put(key,value);
                }else{
                    if ("image".equals(item.getFieldName())){
                        if (item.getContentType().startsWith("image")){
                            String imageName = item.getName();
                            String imageType = item.getContentType();
                            String uuid = UUID.randomUUID().toString();

                            image = new File(realPath,uuid);
                            item.write(image);

                            String imagePath = image.getAbsolutePath();
                            System.out.println(imagePath);
                            bookImage.setImage(uuid);
                            bookImage.setImageName(imageName);
                            bookImage.setImageType(imageType);
                            bookImage.setImagePath(imagePath);

                        }
                    }
                }
            }

//            将图书图片插入到图书图片表中


//            con.setAutoCommit(false);
//
////            String imgInsertSql = "insert into book_image value (?, ?, ?, ?)";
////            Object[] params={bookImage.getImage(),bookImage.getImageName(),bookImage.getImageType(),bookImage.getImagePath()};
//            QueryRunner qr = new QueryRunner();
////            int update = qr.update(con, imgInsertSql, params);
////            System.out.println(update+ "图片插入成功,再接再厉!");
//
////              将图书信息插入图书表中
//            String bookInsertSql = "insert into book(bname,price,author,image,cid) value(?, ?, ?, ?, ?)";
//            Object[] params2 = {map.get("bname"),map.get("price"),map.get("author"),
//                    bookImage.getImage(),map.get("cid")};
//            int update1 = qr.update(con, bookInsertSql, params2);
//            System.out.println(update1 + "书本插入成功,继续努力");
//            DbUtils.commitAndCloseQuietly(con);


            int i = iCategoryService.addBook(map.get("bname"), Float.parseFloat(map.get("price")), map.get("author"), bookImage.getImage(), Integer.parseInt(map.get("cid")));


            msg = "添加图书成功!";
        }
        catch (Exception e) {
            e.printStackTrace();
            if (image != null){
                image.delete();
            }
//            DbUtils.rollbackAndCloseQuietly(con);
            msg = "添加图书失败!";
        }finally {
            req.setAttribute(message,msg);
            resp.sendRedirect("/adminjsps/admin/book/add.jsp");
        }

    }







    private void operation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        System.out.println(method);

        String bname = req.getParameter("bname");
        String oname = req.getParameter("oname");
        float price = Float.parseFloat(req.getParameter("price"));
        String author = req.getParameter("author");
        int cid = Integer.parseInt(req.getParameter("cid"));

        if (method.equals("mod")) {
            int i = iCategoryService.modBook(oname, bname, price, author, cid);
            System.out.println(i);

        } else if (method.equals("del")) {
            int i = iCategoryService.delBook(oname);
            System.out.println(i);
        }

        resp.sendRedirect("/adminjsps/admin/book/list.jsp");
    }


    private void verify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* --------- 管理员账户相关 --------- */
        String adminName = req.getParameter("adminname");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        // 判断用户名和密码是否正确
        if (adminName.equals("admin") && password.equals("admin")) {
            session.setAttribute("admin", "OK");
            req.getRequestDispatcher("/adminjsps/admin/index.jsp").forward(req, resp);
        } else {
            session.removeAttribute("admin");
            req.setAttribute("msg", "用户名或密码不正确!");
            req.getRequestDispatcher("/adminjsps/login.jsp").forward(req, resp);
            req.removeAttribute("msg");
        }

    }
}
