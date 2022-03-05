package com.example.poshell.db;

import com.example.poshell.model.Cart;
import com.example.poshell.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;
public class PosRedisDB implements PosDB{
    Jedis jedis=new Jedis("localhost");

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Cart saveCart(Cart cart) {
        for(var item : cart.getItems())
        jedis.lpush("cart", item.toString());
        return null;
    }

    @Override
    public Cart getCart() {
        return null;
    }

    @Override
    public Product getProduct(String productId) {
        return null;
    }

    public static void main(String[] args){


        //Redis hash 是一个string类型的field和value的映射表，hash特别适合用于存储对象。
        //这里要求的是map必须是key和value都是string类型的
//        Map<String, String> map=new HashMap<>();
//        map.put("name", "小明");
//        map.put("age", "13");
//        map.put("sex", "男");
//        map.put("height", "174");
//
//        jedis.set("name","key");
//        System.out.println(jedis.get("name"));
    }
}
