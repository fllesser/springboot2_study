package com.chowyijiu.boot.pro05_ssm_to_boot.service;


import com.chowyijiu.boot.pro05_ssm_to_boot.pojo.Employee;
import com.github.pagehelper.PageInfo;


import java.util.List;


public interface EmployeeService {
    List<Employee> getAllEmployee();

    PageInfo<Employee> getEmployeePage(Integer pageNo);

    void save(Employee employee);

    void deleteEmployee(Integer empId);

    Employee getEmployeeById(Integer empId);

    void updateEmployee(Employee employee);
}
