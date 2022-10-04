package com.chowyijiu.boot.controller;

import com.chowyijiu.boot.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table() {
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model) {
        //表格内容的遍历
        List<User> users = Arrays.asList(
                new User("zhangsan", "123456"),
                new User("lisi", "12312"),
                new User("lkp", "lkp010703"),
                new User("ts", "sdtfsadf"));
        model.addAttribute("users", users);
        return "table/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table() {
        return "table/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricing_table() {
        return "table/pricing_table";
    }

    @GetMapping("/responsive_table")
    public String response_table() {
        return "table/responsive_table";
    }

}
