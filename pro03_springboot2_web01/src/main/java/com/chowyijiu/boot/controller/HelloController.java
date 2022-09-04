package com.chowyijiu.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @ResponseBody
    @RequestMapping("cat.png")
    public String hello() {
        return "aaa";
    }

}
