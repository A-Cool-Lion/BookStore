package com.lanou.bookstore.book.service;

import com.lanou.bookstore.book.dao.BookDao;
import com.lanou.bookstore.book.dao.IBookDao;
import com.lanou.bookstore.book.domain.BookCategory;
import com.lanou.bookstore.common.ResultWrapper;

import java.util.List;

/**
 * Created by : dllo on 18/9/3.
 */
public class BookService implements IService {

    private IBookDao bookDao = new BookDao();
    @Override
    public ResultWrapper findBook(){
        try {
            int totalCount = bookDao.findTotalCount();
            List<BookCategory> book = bookDao.findBook();
            return ResultWrapper.success(totalCount,book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultWrapper.error(444,"查询的数据不存在");
        }
    }
}
