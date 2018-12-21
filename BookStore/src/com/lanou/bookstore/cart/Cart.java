package com.lanou.bookstore.cart;

import com.lanou.bookstore.cart.domain.CartItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private List<CartItem> list;
    private Map<String, CartItem> map;



    public Cart() {
        map = new HashMap<>();
    }

    public Cart(List<CartItem> list) {
        this.list = list;
    }

    public Cart(Map<String, CartItem> map) {
        this.map = map;
    }

    public List<CartItem> getList() {
        return list;
    }

    public void setList(List<CartItem> list) {
        this.list = list;
    }

    public Map<String, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<String, CartItem> map) {
        this.map = map;
    }
}
