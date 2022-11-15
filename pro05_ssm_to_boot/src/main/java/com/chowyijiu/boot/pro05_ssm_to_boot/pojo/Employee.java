package com.chowyijiu.boot.pro05_ssm_to_boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Employee {
    private Integer empId;
    private String empName;
    private Integer age;
    private Integer gender;
    private String email;
}
