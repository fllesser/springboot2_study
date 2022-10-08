package com.chowyijiu.boot.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Slf4j
//@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("project 初始化完成");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("project 销毁");
    }
}
