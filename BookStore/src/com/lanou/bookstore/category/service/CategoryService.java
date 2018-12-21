package com.lanou.bookstore.category.service;

import com.lanou.bookstore.category.common.ResultWrapper;
import com.lanou.bookstore.category.dao.CategoryDao;
import com.lanou.bookstore.category.dao.CategoryDaoImpl;
import com.lanou.bookstore.category.domain.CategoryBean;

import java.util.List;

public class CategoryService implements ICategoryService {

    private CategoryDao categoryDao = new CategoryDaoImpl();


    @Override
    public ResultWrapper searchCategory() {
        try {

            int queryTotalCount = categoryDao.queryTotalCount();
            List<CategoryBean> categoryBeanList = categoryDao.queryBookName();

            return ResultWrapper.success(queryTotalCount, categoryBeanList);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultWrapper.error(406, "您查询的数据不存在");
        }
    }

    @Override
    public int addCategory(String categoryName) {
        try {
            return categoryDao.addCategory(categoryName);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delCategory(String categoryName) {
        try {
            return categoryDao.delCategory(categoryName);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int changeCategory(String oldName, String newName) {
        try {
            return categoryDao.modCategory(oldName, newName);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int addBook(String bookName, float price, String author, String uuid, int cid) {
        try {
            return categoryDao.addBook(bookName, price, author, uuid, cid);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;

        }
    }

    @Override
    public int delBook(String bookName) {
        try {
            return categoryDao.delBook(bookName);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;

        }
    }

    @Override
    public int modBook(String bookName, String newName, float newPrice, String newAuthor, int newCid) {
        try {
            return categoryDao.modBook(bookName, newName, newPrice, newAuthor, newCid);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;

        }
    }


}
