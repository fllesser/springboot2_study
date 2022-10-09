package com.chowyijiu.boot.pro04_springboot2_admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class Pro04Springboot2AdminApplicationTests {

    @Resource
    JdbcTemplate jdbcTemplate; //这里不要用@AutoWired

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("SELECT count(*) FROM  t_emp", Long.class);
        log.info("总记录数 " + aLong);
    }


}
