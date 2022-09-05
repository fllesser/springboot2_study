package com.chowyijiu.boot;

import com.chowyijiu.boot.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Field;

@SpringBootApplication
public class Pro02Springboot2Helloworld2Application {

    public static void main(String[] args) throws IllegalAccessException {
        ConfigurableApplicationContext run = SpringApplication.run(Pro02Springboot2Helloworld2Application.class, args);
        Person bean = run.getBean(Person.class);
        System.out.println(bean);
        Field[] fields = Person.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.get(bean));
        }
    }

}
