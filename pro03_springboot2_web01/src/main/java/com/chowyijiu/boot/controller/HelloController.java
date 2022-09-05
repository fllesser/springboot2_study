package com.chowyijiu.boot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping("cat.png")
    public String hello() {
        return "aaa";
    }

    @GetMapping("/user")
    public String getUser() {
        return "Get 张三";
    }

    @PostMapping("/user")
    public String saveUser() {
        return "Post 张三";
    }

    @PutMapping("/user")
    public String putUser() {
        return "Put 张三";
    }

    @DeleteMapping("/user")
    public String deleteUser() {
        return "Delete 张三";
    }
}
