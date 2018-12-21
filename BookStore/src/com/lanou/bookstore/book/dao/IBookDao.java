package com.lanou.bookstore.book.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by : dllo on 18/9/3.
 */
public interface IBookDao<T> {

    int findTotalCount() throws Exception;
    List<T> findBook() throws SQLException;

}
