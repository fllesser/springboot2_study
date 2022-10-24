package com.chowyijiu.redis.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 在企业中, 我们的所有pojo都会序列化
public class Person implements Serializable {

    private String name;
    private Integer age;

}
