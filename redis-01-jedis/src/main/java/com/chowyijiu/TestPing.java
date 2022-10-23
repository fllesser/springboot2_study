package com.chowyijiu;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;


public class TestPing {
    public static void main(String[] args) {
        //1. new Jedis()
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //2 Jedis 的所有命令就是我们之前学的所有指令
        System.out.println(jedis.ping());
        jedis.flushDB();
        jedis.set("money", "100");
        jedis.watch("money");
        Transaction multi = jedis.multi();
        multi.incrBy("money", 1000);
        multi.decrBy("money", 100);
        multi.exec();
        System.out.println(jedis.get("money"));
        jedis.close();

    }
}
