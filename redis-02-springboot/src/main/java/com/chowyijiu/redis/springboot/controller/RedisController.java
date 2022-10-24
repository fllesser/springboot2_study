package com.chowyijiu.redis.springboot.controller;

import com.chowyijiu.redis.springboot.pojo.Person;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@RestController

public class RedisController {

    @Resource
    private RedisTemplate<Serializable, Object> redisTemplate;

    @GetMapping("/flush")
    public String TestRedis() {
        RedisConnection connection = Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection();
        connection.flushDb();
        Date date = new Date();
        return date + " redis flush db 0 complete";
    }

    @GetMapping("/redis")
    public String TestRedis2() {
        //真实的开发一般都使用json来传递对象
        Person kuangshen = new Person("狂神", 23);
        //String jsonKuangshen = new ObjectMapper().writeValueAsString(kuangshen);
        redisTemplate.opsForValue().set("kuangshen", kuangshen);
        return Objects.requireNonNull(redisTemplate.opsForValue().get("kuangshen")).toString();
    }

}
