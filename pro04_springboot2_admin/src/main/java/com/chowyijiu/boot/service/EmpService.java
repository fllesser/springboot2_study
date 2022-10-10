package com.chowyijiu.boot.service;

import com.chowyijiu.boot.bean.Emp;
import com.chowyijiu.boot.mapper.EmpMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmpService {

    @Resource
    EmpMapper empMapper;

    public Emp getEmpById(Integer empId) {
        return empMapper.getEmpById(empId);
    }
}
