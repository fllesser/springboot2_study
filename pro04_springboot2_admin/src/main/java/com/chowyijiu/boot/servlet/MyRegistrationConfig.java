package com.chowyijiu.boot.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.servlet.ServletContextListener;
import java.util.Arrays;


/**
 * 1. MyServlet --> /my
 * 2. DispatcherServlet --> /
 */
// (proxyBeanMethods = false)
@Configuration
public class MyRegistrationConfig {

    @Bean
    public ServletRegistrationBean<Servlet> myServlet() {

        MyServlet myServlet = new MyServlet();
        return new ServletRegistrationBean<>(myServlet, "/my", "/my02");
    }

    @Bean
    public FilterRegistrationBean<Filter> myFilter() {
        MyFilter myFilter = new MyFilter();
        //return new FilterRegistrationBean<>(myFilter, myServlet());
        //上面myServlet是什么路径,就拦截什么
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>(myFilter);
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/my", "/css"));
        return filterFilterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<ServletContextListener> myListener() {
        MyServletContextListener myServletContextListener = new MyServletContextListener();
        return new ServletListenerRegistrationBean<>(myServletContextListener);
    }
}
