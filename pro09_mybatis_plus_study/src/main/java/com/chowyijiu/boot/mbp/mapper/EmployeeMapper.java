package com.chowyijiu.boot.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chowyijiu.boot.mbp.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
