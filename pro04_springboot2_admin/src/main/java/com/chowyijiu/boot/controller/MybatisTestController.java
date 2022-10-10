package com.chowyijiu.boot.controller;

import com.chowyijiu.boot.bean.City;
import com.chowyijiu.boot.bean.Emp;
import com.chowyijiu.boot.service.CityService;
import com.chowyijiu.boot.service.EmpService;
import com.chowyijiu.boot.service.impl.CityServiceImpl;
import com.chowyijiu.boot.service.impl.EmpServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class MybatisTestController {

    @Resource
    EmpService empService;

    @Resource
    CityService cityService;

    @GetMapping("/emp")
    public Emp getEmpById(@RequestParam("empId") Integer empId) {
        return empService.getEmpById(empId);
    }

    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id) {
        return cityService.getCityById(id);
    }

    @PostMapping("/city")
    public City saveCity(City city) {
        cityService.saveCity(city);
        return city;
    }
}
