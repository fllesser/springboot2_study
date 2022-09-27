package com.chowyijiu.boot.controller;

import com.chowyijiu.boot.bean.Person;
import com.chowyijiu.boot.bean.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseController {

    @ResponseBody
    @GetMapping("/test/person")
    public Person getPerson() {
        Person person = new Person();
        person.setUserName("lkp");
        person.setAge(21);
        person.setBirth(new Date());
        person.setPet(new Pet("牛牛", 10));
        return person;
    }
}
