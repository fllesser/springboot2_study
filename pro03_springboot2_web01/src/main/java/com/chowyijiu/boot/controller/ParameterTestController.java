package com.chowyijiu.boot.controller;


import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(
            @PathVariable("id") Integer id,
            @PathVariable("username") String username,
            @PathVariable Map<String, Object> pv,
            @RequestHeader("User-Agent") String userAgent,
            @RequestHeader Map<String, String> header,
            @RequestParam("age") Integer age,
            @RequestParam("inters") List<String> inters,
            @RequestParam Map<String, String> params
    ) {
        System.out.println("id = " + id);
        System.out.println("username = " + username);
        System.out.println("pv = " + pv);
        System.out.println("userAgent = " + userAgent);
        System.out.println("header = " + header);
        System.out.println("age = " + age);
        System.out.println("inters = " + inters);
        System.out.println("params = " + params);
        return null;
    }


    @PostMapping("/save")
    public Map<String, Object> postMethod(
         @RequestParam Map<String, Object> content
    ) {
        System.out.println("content = " + content);
        return content;
    }

}
