package com.chowyijiu.boot.pro05_ssm_to_boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer empId;
    private String empName;
    private Integer age;
    private Integer gender;
    private String email;
}
