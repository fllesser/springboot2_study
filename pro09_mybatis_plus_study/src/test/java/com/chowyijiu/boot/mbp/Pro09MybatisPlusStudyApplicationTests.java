package com.chowyijiu.boot.mbp;

import com.chowyijiu.boot.mbp.mapper.EmpMapper;
import com.chowyijiu.boot.mbp.mapper.UserMapper;
import com.chowyijiu.boot.mbp.pojo.Emp;
import com.chowyijiu.boot.mbp.pojo.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

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
        Assertions.assertEquals(5, users.size());
        users.forEach(System.out::println);
    }

    @Test
    void test1() {
        List<Emp> emps = empMapper.selectList(null);
        emps.forEach(System.out::println);
    }


}
