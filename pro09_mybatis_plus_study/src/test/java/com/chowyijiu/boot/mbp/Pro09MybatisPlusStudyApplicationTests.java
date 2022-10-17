package com.chowyijiu.boot.mbp;


import com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper;
import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chowyijiu.boot.mbp.mapper.EmpMapper;
import com.chowyijiu.boot.mbp.mapper.UserMapper;
import com.chowyijiu.boot.mbp.pojo.Emp;
import com.chowyijiu.boot.mbp.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class Pro09MybatisPlusStudyApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Resource
    private EmpMapper empMapper;

    @Test
    void contextLoads() {
        System.out.println("====== Select Method =====");
        List<User> users = userMapper.selectList(null);
        assertEquals(5, users.size());
        users.forEach(System.out::println);
    }

    @Test
    void test1() {
        List<Emp> emps = empMapper.selectList(new QueryWrapper<Emp>().in("age", 99));
        emps.forEach(System.out::println);
        empMapper.insert(new Emp(null, "chowyijiu", 99, 0, "19550518zrf@gmail.com"));

    }
}
