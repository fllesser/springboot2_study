package com.chowyijiu.boot.pro05_ssm_to_boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chowyijiu.boot.pro05_ssm_to_boot.mapper")
public class Pro05SsmToBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Pro05SsmToBootApplication.class, args);
    }

}
