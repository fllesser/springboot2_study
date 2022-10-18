package com.chowyijiu.boot.mbp.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@TableName("t_emp")
@AllArgsConstructor
public class Employee {
    @TableId
    private Integer empId;
    private String empName;
    private Integer age;
    private Integer gender;
    private String email;
}
