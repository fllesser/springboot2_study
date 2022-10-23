package com.chowyijiu;

import com.google.gson.JsonObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTX {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("hello", "world");
        jsonObject.addProperty("name", "chowyijiu");

        System.out.println(jsonObject);
        //清空redis
        jedis.flushDB();
        //开启事务
        Transaction multi = jedis.multi();
        try {
            multi.set("user1", jsonObject.toString());
            multi.set("user2", jsonObject.toString());
            int i = 1 / 0;
            multi.exec();
        } catch (Exception e) {
            multi.discard(); //放弃事务
            e.printStackTrace();
        } finally {
            System.out.println("user1: " + jedis.get("user1"));
            System.out.println("user2: " + jedis.get("user2"));
            jedis.close();
        }
    }
}
