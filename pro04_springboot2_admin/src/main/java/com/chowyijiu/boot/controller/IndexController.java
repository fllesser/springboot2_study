package com.chowyijiu.boot.controller;

import com.chowyijiu.boot.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    /**
     * 登陆页
     * @return String
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (StringUtils.hasLength(user.getUserName()) &&
                user.getUserName().equals("admin") &&
                StringUtils.hasLength(user.getPassword())) {
            //把登陆成功的用户保存起来
            session.setAttribute("loginUser", user);
            //登陆成功重定向到main.html, 重定向防止表单重复提交
            return "redirect:main.html";
        } else {
            model.addAttribute("msg", "账号或密码错误");
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
        //是否登陆, 拦截器, 过滤器
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return "main";
        } else {
            model.addAttribute("msg", "请重新登陆");
            return "login";
        }
    }
}
