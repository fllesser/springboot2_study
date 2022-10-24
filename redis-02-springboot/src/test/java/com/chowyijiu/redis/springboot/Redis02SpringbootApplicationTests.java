package com.chowyijiu.redis.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.io.Serializable;

@SpringBootTest
class Redis02SpringbootApplicationTests {

    @Resource
    private RedisTemplate<Serializable, Object> redisTemplate;

    @Test
    void contextLoads() {
        //在企业开发中, 我们80%的情况下,都不会使用这个原生的方式去编写代码
        //redisTemplate
        //opsForValue 操作String
        //opsForList 操作List
        //opsForSet 操作Set...
        //除了基本的操作, 我们常用的方法都可以直接通过redisTemplate操作, 比如事务和基本的CRUD
        //获取Redis的连接对象
            //RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
            //connection.flushDb();
            //connection.flushAll();
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("hello", "world");
        valueOperations.set("name", "chowyijiu");


        System.out.println("" + valueOperations.get("hello") + valueOperations.get("name"));
    }

}
