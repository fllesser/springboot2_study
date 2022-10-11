package com.chowyijiu.boot.pro05_ssm_to_boot.service.impl;

import com.chowyijiu.boot.pro05_ssm_to_boot.bean.Employee;
import com.chowyijiu.boot.pro05_ssm_to_boot.mapper.EmployeeMapper;
import com.chowyijiu.boot.pro05_ssm_to_boot.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNo) {
        //开启分页功能
        PageHelper.startPage(pageNo, 8);
        //查询所有的员工信息
        List<Employee> list = getAllEmployee();
        //获取分页相关数据
        //PageInfo<Employee> page = new PageInfo<>(list, 5);
        return new PageInfo<>(list, 3);
    }

    @Override
    public void save(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer empId) {
        employeeMapper.deleteEmployee(empId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(Integer empId) {
        return employeeMapper.getEmployeeById(empId);
    }
}
