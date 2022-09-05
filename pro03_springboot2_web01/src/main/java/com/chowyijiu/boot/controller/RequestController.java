package com.chowyijiu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(
            HttpServletRequest request
    ) {
        request.setAttribute("msg", "成功了");
        request.setAttribute("code", 200);
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public String success(
            @RequestAttribute("msg") String msg,
            @RequestAttribute("code") Integer code,
            HttpServletRequest request
    ) {
        System.out.println("msg = " + msg);
        System.out.println("code = " + code);
        System.out.println((request.getAttribute("msg")));
        return msg;
    }



}

