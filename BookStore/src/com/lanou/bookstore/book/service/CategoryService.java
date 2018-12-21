package com.lanou.bookstore.book.service;

import com.lanou.bookstore.book.dao.CategoryDao;
import com.lanou.bookstore.book.dao.IBookDao;
import com.lanou.bookstore.book.domain.CategoryBean;
import com.lanou.bookstore.common.ResultWrapper;

import java.util.List;

/**
 * Created by : dllo on 18/9/3.
 */
public class CategoryService implements IService {
    private IBookDao dao = new CategoryDao();

    @Override
    public ResultWrapper findBook() {

        try {
           int totalCount = dao.findTotalCount();
            List<CategoryBean> book = dao.findBook();
        return ResultWrapper.success(totalCount,book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultWrapper.error(444,"你查询的数据不存在");
        }

    }
}
