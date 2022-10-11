package com.chowyijiu.boot.pro05_ssm_to_boot.mapper;

import com.chowyijiu.boot.pro05_ssm_to_boot.bean.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EmployeeMapper {

    @Select("SELECT * FROM t_emp")
    //@ResultMap("Employee")
    List<Employee> getAllEmployee();

    @Insert("INSERT INTO t_emp VALUES (NULL, #{empName}, #{age}, #{gender}, #{email})")
    void addEmployee(Employee employee);

    @Delete("DELETE FROM t_emp WHERE emp_id=#{empId}")
    void deleteEmployee(Integer empId);

    @Update("UPDATE t_emp SET emp_name=#{empName},age=#{age},gender=#{gender},email=#{email} WHERE emp_id=#{empId}")
    void updateEmployee(Employee employee);

    @Select("SELECT * FROM t_emp WHERE emp_id=#{empId}")
    Employee getEmployeeById(Integer empId);
}
