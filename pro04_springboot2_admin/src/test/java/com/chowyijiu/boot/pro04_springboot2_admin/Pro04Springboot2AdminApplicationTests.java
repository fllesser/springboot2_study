package com.chowyijiu.boot.pro04_springboot2_admin;

import com.chowyijiu.boot.bean.User;
import com.chowyijiu.boot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
@SpringBootTest
class Pro04Springboot2AdminApplicationTests {

    @Resource
    JdbcTemplate jdbcTemplate; //这里不要用@AutoWired

    @Resource
    DataSource dataSource;

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("SELECT count(*) FROM  t_emp", Long.class);
        log.info("总记录数 " + aLong);
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM t_emp");
        list.forEach((s) -> log.info(s + ""));
    }

    @Test
    void testDruidDataSource() {
        log.info("dataSource type" + dataSource);
    }

    @Resource
    UserMapper userMapper;

    @Test
    void testUserMapper() {
        User user = userMapper.selectById(2L);
        log.info("用户信息" + user);
    }
}
