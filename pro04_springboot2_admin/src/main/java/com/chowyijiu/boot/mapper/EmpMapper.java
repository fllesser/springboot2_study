package com.chowyijiu.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chowyijiu.boot.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface EmpMapper extends BaseMapper<Emp> {

    Emp getEmpById(Integer empId);

}