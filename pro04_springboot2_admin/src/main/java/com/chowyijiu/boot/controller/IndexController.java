package com.chowyijiu.boot.controller;

import com.chowyijiu.boot.bean.Emp;
import com.chowyijiu.boot.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class IndexController {

//    @Resource
//    JdbcTemplate jdbcTemplate;

    /**
     * 测试Druid数据库监控页
     * @return
     */
//    @ResponseBody
//    @GetMapping("/sql")
//    public String queryFromDb() {
//        Long aLong = jdbcTemplate.queryForObject("SELECT count(*) FROM  t_emp", Long.class);
//        log.info("总记录数 " + aLong);
//        return aLong + "";
//    }
//
//    @ResponseBody
//    @GetMapping("/sql2")
//    public String queryFromDb2() {
//        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM t_emp");
//        List<Emp> emps = new ArrayList<>();
//        list.forEach((map) -> emps.add(toEmp(map)));
//        return emps + "";
//    }

    public Emp toEmp(Map<String, Object> map) {
        Emp emp = new Emp();
        emp.setEmpId((Integer) map.get("emp_id"));
        emp.setEmpName((String) map.get("emp_name"));
        emp.setAge((Integer) map.get("age"));
        emp.setGender((Integer) map.get("gender"));
        emp.setEmail((String) map.get("email"));
        return emp;
    }


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
