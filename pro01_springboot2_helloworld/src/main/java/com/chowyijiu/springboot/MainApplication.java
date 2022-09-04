package com.chowyijiu.springboot;

import ch.qos.logback.core.db.DBHelper;
import com.chowyijiu.springboot.bean.Car;
import com.chowyijiu.springboot.bean.Cat;
import com.chowyijiu.springboot.bean.User;
import com.chowyijiu.springboot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.CharacterEncodingFilter;


//@SpringBootApplication一个顶三
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.chowyijiu.springboot")
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        //1. 返回ioc容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        Car car = run.getBean(Car.class);
        System.out.println("car = " + car);

        Cat cat = run.getBean(Cat.class);
        System.out.println("cat = " + cat);

        User user = run.getBean(User.class);
        System.out.println("user = " + user);


//        boolean b = run.containsBean("user01");
//        System.out.println("user01  " + b);
//
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println("bean = " + bean);
//
//        User user01 = bean.user01();
//        System.out.println("user01 = " + user01);
        //2. 查看容器里面的组件s
//        String[] names = run.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }

//        //3.
//        Cat tom01 = run.getBean("tom", Cat.class);
//        Cat tom02 = run.getBean("tom", Cat.class);
//
//        //System.out.println("组件: " + (tom01 == tom02));
//
//        //4. bean = com.chowyijiu.springboot.config.MyConfig$$EnhancerBySpringCGLIB$$49979cdb@2577d6c8
//        MyConfig bean = run.getBean(MyConfig.class);
//        //System.out.println("bean = " + bean);
//
//        User user01 = bean.user01();
//        User user02 = bean.user01();
//
//        //System.out.println("user01 == user02 result: " + (user01 == user02));
//
//        //5. 获取组件
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }

//        DBHelper dbHelper = run.getBean(DBHelper.class);
//        System.out.println(dbHelper);
//        boolean tom = run.containsBean("tom");
//        System.out.println("容器中Tom组件: " + tom);
//
//        boolean user01 = run.containsBean("user01");
//        System.out.println("容器中user01组件: " + user01);

    }
}
