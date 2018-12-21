//package com.lanou.bookstore.book.admin.web.servlet;
//
//import com.lanou.bookstore.book.domain.BookImageBean;
//import com.lanou.bookstore.datasource.ComboPool;
//import com.mchange.v2.c3p0.ComboPooledDataSource;
//import org.apache.commons.dbutils.DbUtils;
//import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileItemFactory;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.apache.commons.io.FileUtils;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.IOException;
//import java.sql.Connection;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//
///**
// * Created by : dllo on 18/9/3.
// * 这个Servlet用来添加图书, 向图书表中插入图书
// */
//@WebServlet(name = "AdminBookServlet", urlPatterns = "/admin/book")
//public class AdminBookServlet extends HttpServlet {
//
//    private static final String message = "message";
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=utf-8");
//
//        ServletContext ctx = getServletContext();
//        String realPath = ctx.getRealPath("book-image");
//        FileUtils.forceMkdir(new File(realPath));
//
//        FileItemFactory factory = new DiskFileItemFactory();
//        ServletFileUpload up = new ServletFileUpload(factory);
//        up.setHeaderEncoding("utf-8");
//        up.setFileSizeMax(2 * 1024 * 1024);
//        up.setSizeMax(5 * 1024 * 1024);
//
//        ComboPooledDataSource ds = ComboPool.getDataSource();
//        Connection con = null;
//        File image = null;
//        String msg = null;
//
//        try {
//            con = ds.getConnection();
//            List<FileItem> fileItems = up.parseRequest(req);
//            BookImageBean bookImage = new BookImageBean();
//            Map<String,String> map = new HashMap<>();
//            for (FileItem item : fileItems) {
//                if (item.isFormField()){
//                    String key = item.getFieldName();
//                    String value = item.getString("utf-8");
//                    map.put(key,value);
//                }else{
//                    if ("image".equals(item.getFieldName())){
//                        if (item.getContentType().startsWith("image")){
//                            String imageName = item.getName();
//                            String imageType = item.getContentType();
//                            String uuid = UUID.randomUUID().toString();
//
//                            image = new File(realPath,uuid);
//                            item.write(image);
//
//                            String imagePath = image.getAbsolutePath();
//                            System.out.println(imagePath);
//                            bookImage.setImage(uuid);
//                            bookImage.setImageName(imageName);
//                            bookImage.setImageType(imageType);
//                            bookImage.setImagePath(imagePath);
//
//                        }
//                    }
//                }
//            }
//
////            将图书图片插入到图书图片表中
//
//
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
//
//            msg = "添加图书成功!";
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            if (image != null){
//                image.delete();
//            }
//            DbUtils.rollbackAndCloseQuietly(con);
//            msg = "添加图书失败!";
//        }finally {
//            req.setAttribute(message,msg);
//            resp.sendRedirect("/adminjsps/admin/book/add.jsp");
//        }
//
//
//    }
//}
