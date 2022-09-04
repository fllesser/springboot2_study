package com.chowyijiu.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@ToString
public class User {

    private String name;

    private Integer age;

    private Cat cat;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
