package com.chowyijiu.boot.service.impl;

import com.chowyijiu.boot.bean.Emp;
import com.chowyijiu.boot.mapper.EmpMapper;
import com.chowyijiu.boot.service.CityService;
import com.chowyijiu.boot.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    EmpMapper empMapper;

    @Override
    public Emp getEmpById(Integer empId) {
        return empMapper.getEmpById(empId);
    }
}
