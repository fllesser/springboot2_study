package com.chowyijiu.springboot.config;


import com.chowyijiu.springboot.bean.Car;
import com.chowyijiu.springboot.bean.Cat;
import com.chowyijiu.springboot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


//@Import({User.class, DBHelper.class})
@Configuration  // 告诉SpringBoot这是一个配置类 == 配置文件
//@ImportResource("classpath:beans.xml")
@EnableConfigurationProperties(Car.class) // 开启属性配置功能, 1. 开启Car配置绑定功能, 把这个Car组件自动注册到容器中
public class MyConfig {


    @Bean(name = "tom")
    public Cat tomcatPet() {
        System.out.println("cat 加载了");
        return new Cat("tomcat");
    }

    @Bean //给容器中添加组件, 以方法名作为组件的id, 返回类型就是组件类型, 返回值就是组件在容器的中实例
    @ConditionalOnBean(name = {"tom"}) //注意bean加载优先级问题, 同类中按定义顺序加载
    public User user() {
        System.out.println("user加载了");
        User user = new User("zhangsan", 18);
        user.setCat(tomcatPet());
        return user;
    }


}
