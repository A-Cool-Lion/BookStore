package com.lanou.bookstore.category.service;

import com.lanou.bookstore.category.common.ResultWrapper;

public interface ICategoryService {

    ResultWrapper searchCategory();

    int addCategory(String categoryName);

    int delCategory(String categoryName);

    int changeCategory(String oldName, String newName);


    int addBook(String bookName, float price, String author, String uuid, int cid);

    int delBook(String bookName);
    // , float price, String author, String uuid, int cId

    int modBook(String bookName, String newName, float newPrice, String newAuthor, int newCid);


}
