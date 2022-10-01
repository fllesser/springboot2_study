package com.chowyijiu.boot.bean;


import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Person {

    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;

}
