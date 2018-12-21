package com.lanou.bookstore.category.dao;

import com.lanou.bookstore.category.domain.CategoryBean;

import java.util.List;

/**
 * 查询图书分类总接口
 * 提供方法:
 *     1. 查询出数据库中图书分类总条目数
 *     2. 查询出数据库中分类名称集合 List<CategoryBean>
 */
public interface CategoryDao {

    int queryTotalCount() throws Exception;

    List<CategoryBean> queryBookName() throws Exception;

    int addCategory(String categoryName) throws Exception;

    int delCategory(String categoryName) throws Exception;

    int modCategory(String oldName, String newName) throws Exception;

    int addBook(String bookName, float price, String author, String uuid, int cid) throws Exception;

    int delBook(String bookName) throws Exception;
    // , float price, String author, String uuid, int cId

    int modBook(String bookName, String newName, float newPrice, String newAuthor, int newCid) throws Exception;

}
