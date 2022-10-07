package com.chowyijiu.boot.config;

import com.chowyijiu.boot.intercepter.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1. 编写一个拦截器实现HandlerInterceptor接口
 * 2. 拦截器注册到容器中(实现WebMvcConfigurer的addInterceptor)
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //所有请求都会拦截, 包括静态资源
                .excludePathPatterns("/", "/login", "/css/**", "/js/**", "/fonts/**", "/images/**");  // 放行请求
    }
}
