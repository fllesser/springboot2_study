package com.chowyijiu.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;

@Slf4j
//@Configuration
@Deprecated
public class MyDataSourceConfig {

    // 默认的自动配置@ConditionalOnMissingBean({DataSource.class, XADataSource.class})
    // 是判断容器中没有DataSource才自动配置
    //@Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl();
//        druidDataSource.setUsername("root");
//        druidDataSource.setUr
        log.info("DruidDataSource 自动配置完成");
        //加入监控功能
        druidDataSource.setFilters("stat,wall"); //stat:Sql监控 wall:防火墙
        //druidDataSource.setMaxActive(10);
        return druidDataSource;
    }

    /**
     * 配置Druid的监控页功能
     * @return
     */
    //@Bean
    public ServletRegistrationBean<? extends Servlet> statViewServlet() {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
        registrationBean.addInitParameter("loginUsername", "admin");
        registrationBean.addInitParameter("loginPassword", "123456");
        return registrationBean;
    }

    /**
     * WebStatFilter 用来采集web-jdbc关联监控的数据
     */
    //@Bean
    public FilterRegistrationBean<? extends Filter> WebStatFilter() {
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        filterRegistrationBean.setUrlPatterns(Collections.singletonList("/*"));
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
