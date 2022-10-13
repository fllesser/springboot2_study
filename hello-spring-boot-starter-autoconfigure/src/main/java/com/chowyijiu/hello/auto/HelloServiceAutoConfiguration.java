package com.chowyijiu.hello.auto;

import com.chowyijiu.hello.bean.HelloProperties;
import com.chowyijiu.hello.service.HelloService;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootConfiguration
@ConditionalOnMissingBean({HelloService.class})
@EnableConfigurationProperties({HelloProperties.class}) //放到容器中
public class HelloServiceAutoConfiguration {

    public HelloServiceAutoConfiguration() {
    }

    @ConditionalOnMissingBean(HelloService.class)
    @Bean
    public HelloService helloService() {
        return new HelloService();
    }
}
