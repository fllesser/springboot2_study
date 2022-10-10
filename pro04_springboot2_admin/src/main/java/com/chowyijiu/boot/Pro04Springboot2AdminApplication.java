package com.chowyijiu.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = "com.chowyijiu.boot.servlet")
//@MapperScan("com.chowyijiu.boot.mapper")
@SpringBootApplication
public class Pro04Springboot2AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(Pro04Springboot2AdminApplication.class, args);
    }

}
