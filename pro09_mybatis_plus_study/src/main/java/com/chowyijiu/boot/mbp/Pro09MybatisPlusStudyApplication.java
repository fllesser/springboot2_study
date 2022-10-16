package com.chowyijiu.boot.mbp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chowyijiu.boot.mbp.mapper")
public class Pro09MybatisPlusStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(Pro09MybatisPlusStudyApplication.class, args);
    }

}
