package com.chowyijiu.boot.mbp;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chowyijiu.boot.mbp.mapper.EmployeeMapper;
import com.chowyijiu.boot.mbp.mapper.UserMapper;
import com.chowyijiu.boot.mbp.pojo.Employee;
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
    private EmployeeMapper employeeMapper;

    @Test
    void contextLoads() {
        System.out.println("====== Select Method =====");
        List<User> users = userMapper.selectList(null);
        assertEquals(5, users.size());
        users.forEach(System.out::println);
    }

    @Test
    void test1() {
        List<Employee> employees = employeeMapper.selectList(new QueryWrapper<Employee>().in("age", 99));
        employees.forEach(System.out::println);
        employeeMapper.insert(new Employee(null, "chowyijiu", 99, 0, "19550518zrf@gmail.com"));

    }
}
