package com.chowyijiu.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chowyijiu.boot.bean.User;
import com.chowyijiu.boot.exception.UserTooManyException;
import com.chowyijiu.boot.service.UserService;
import com.chowyijiu.boot.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Resource
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table() {
        int i = 10 / 0;
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model, @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        //表格内容的遍历
//        List<User> users = Arrays.asList(
//                new User("zhangsan", "123456"),
//                new User("lisi", "12312"),
//                new User("lkp", "lkp010703"),
//                new User("ts", "skd0234"));
//        model.addAttribute("users", users);
//        if (users.size() > 3) {
//            throw new UserTooManyException();
//        }
//        List<User> users = userService.list();
//        model.addAttribute("users", users);

        Page<User> users = userService.page(new Page<User>(pn, 2));
        model.addAttribute("users", users);
        return "table/dynamic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(
            @PathVariable("id") Long id,
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            RedirectAttributes ra) {
        userService.removeById(id);
        ra.addAttribute("pn", pn);
        return "redirect:/dynamic_table";
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
