package com.chowyijiu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

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
    public Map<String, Object> success(
//            @RequestAttribute("msg") String msg,
//            @RequestAttribute("code") Integer code,
            HttpServletRequest request
    ) {
//        System.out.println("msg = " + msg);
//        System.out.println("code = " + code);
        Object hello = request.getAttribute("hello");
        Object world = request.getAttribute("world");
        Object message = request.getAttribute("message");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("hello", hello);
        hashMap.put("world", world);
        hashMap.put("message", message);
        return hashMap;
    }

    @GetMapping("/param")
    public String testParam(
            Map<String, Object> map,
            Model model,
            HttpServletRequest request,
            HttpServletResponse response) {
        map.put("hello", "world666");
        model.addAttribute("world", "hello666");
        request.setAttribute("message", "hello world");

        Cookie cookie = new Cookie("ce", "ve");
        response.addCookie(cookie);
        return "forward:/success";
    }

}

