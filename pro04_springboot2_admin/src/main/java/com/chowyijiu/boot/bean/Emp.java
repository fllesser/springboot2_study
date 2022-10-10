package com.chowyijiu.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Emp {

    private Integer empId;
    private String empName;
    private Integer age;
    private Integer gender;
    private String email;

}
