package com.chowyijiu.boot.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = {"/css/*", "/images/*"}) // Spring /css/**  原生 /css/*
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter初始化完成");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("MyFilter工作");
    }

    @Override
    public void destroy() {
        log.info("MyFilter销毁");
    }
}
