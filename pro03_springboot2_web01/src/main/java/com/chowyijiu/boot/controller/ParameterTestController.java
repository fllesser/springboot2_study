package com.chowyijiu.boot.controller;



import com.chowyijiu.boot.bean.Person;
import org.springframework.web.bind.annotation.*;

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

    ///cars/sell;low=34;brand=byd,audi,yd
    @GetMapping("/cars/{path}")
    public Map<String, Object> carsSell(
            @MatrixVariable("low") Integer low,
            @MatrixVariable("brand") List<String> brand,
            @PathVariable("path") String path
    ) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

    @GetMapping("/boss/{bossId}/{empId}")
    public Map<String, Object> boss(
            @MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
            @MatrixVariable(value = "age", pathVar = "empId") Integer empAge
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);
        return map;
    }

    @PostMapping("/saveuser")
    public Person saveUser(Person person) {
        return person;
    }

}
