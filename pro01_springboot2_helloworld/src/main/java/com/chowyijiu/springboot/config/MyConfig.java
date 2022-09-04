package com.chowyijiu.springboot.config;


import ch.qos.logback.core.db.DBHelper;
import com.chowyijiu.springboot.bean.Cat;
import com.chowyijiu.springboot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = false) // 告诉SpringBoot这是一个配置类 == 配置文件
public class MyConfig {

    @Bean //给容器中添加组件, 以方法名作为组件的id, 返回类型就是组件类型, 返回值就是组件在容器的中实例
    @ConditionalOnBean(name = "tom")
    public User user01() {
        Cat cat = new Cat();
        return new User("zhangsan", 18, cat);
    }

    @Bean("tom01")
    public Cat tomcatPet() {
        return new Cat("tomcat");
    }

}
