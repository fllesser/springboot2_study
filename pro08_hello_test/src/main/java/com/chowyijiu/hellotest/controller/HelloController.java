package com.chowyijiu.hellotest.controller;

import com.chowyijiu.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    HelloService helloService;

    @GetMapping("/")
    public String sayHello() {
        return helloService.sayHello("lkp");
    }
}
