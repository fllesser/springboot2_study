package com.chowyijiu.boot.pro07_features_profile.controller;

import com.chowyijiu.boot.pro07_features_profile.bean.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Value("${person.name}")
    private String name;

    @Resource
    private Person person;

    @GetMapping("/")
    public String hello() {
        //return "hello " + name;
        return person.getClass() + person.toString();
    }

    @Value("${MAVEN_HOME}")
    private String maven_home;

    @GetMapping("/msg")
    public String getMaven_home() {
        return maven_home;
    }

    @Value("${os.name}")
    private String osName;

    @GetMapping("/os")
    public String getOsName() {
        return osName;
    }
}
