package com.chowyijiu.boot.mbp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chowyijiu.boot.mbp.mapper.EmployeeMapper;
import com.chowyijiu.boot.mbp.pojo.Employee;
import com.chowyijiu.boot.mbp.service.EmployeeService;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
