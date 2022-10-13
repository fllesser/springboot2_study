package com.chowyijiu.hellotest.config;

import com.chowyijiu.hello.bean.HelloProperties;
import com.chowyijiu.hello.service.HelloService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({HelloProperties.class})
public class MyConfig {


    @Bean
    public HelloService helloService() {
        return new HelloService();
    }
}
