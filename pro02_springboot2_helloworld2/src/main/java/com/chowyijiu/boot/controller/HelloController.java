package com.chowyijiu.boot.controller;

import com.chowyijiu.boot.bean.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    Person person;

    public HelloController(Person person) {
        this.person = person;
    }

    @RequestMapping("/person")
    public Person person() {
        return person;
    }

}
