package com.lanou.bookstore.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Created by : dllo on 18/9/3.
 */
public class ComboPool{

    private ComboPool(){}

    private final static class Holder{
        public final static ComboPooledDataSource ds = new ComboPooledDataSource();
    }

    public static ComboPooledDataSource getDataSource(){
        return Holder.ds;
    }

}
