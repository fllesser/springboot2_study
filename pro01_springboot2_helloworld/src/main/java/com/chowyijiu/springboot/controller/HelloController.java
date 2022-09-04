package com.chowyijiu.springboot.controller;

import com.chowyijiu.springboot.bean.Car;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    Car car;

    public HelloController(Car car) {
        this.car = car;
    }

    @RequestMapping("/car")
    public Car car() {
        return car;
    }


    @RequestMapping("/hello")
    public String handle01(@RequestParam("name") String name) {
        return "Hello, Spring Boot 2 ! + 你好" + name;
    }

}
