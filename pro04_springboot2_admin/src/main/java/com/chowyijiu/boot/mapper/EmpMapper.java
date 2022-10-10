package com.chowyijiu.boot.mapper;

import com.chowyijiu.boot.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface EmpMapper {

    Emp getEmpById(Integer empId);

}