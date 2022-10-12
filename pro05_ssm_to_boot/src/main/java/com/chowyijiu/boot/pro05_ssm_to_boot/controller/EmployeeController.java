package com.chowyijiu.boot.pro05_ssm_to_boot.controller;

import com.chowyijiu.boot.pro05_ssm_to_boot.pojo.Employee;
import com.chowyijiu.boot.pro05_ssm_to_boot.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 查询所有的员工信息 --> /employee --> get
 * 根据id查询员工信息 --> /employee/1 --> get
 * 跳转到添加页面 --> /to/add --> get
 * 添加员工信息 --> /employee --> post
 * 修改员工信息 --> /employee --> put
 * 删除员工信息 --> /employee/1 --> delete
 */

@Controller
public class EmployeeController {

    @Resource
    EmployeeService employeeService;

    @GetMapping("/employee")
    public String getAllEmployee(Model model) {
        //查询所有的员工信息
        List<Employee> list = employeeService.getAllEmployee();
        //将员工信息在请求域中共享
        model.addAttribute("list", list);
        return "employee_list";
    }

    @GetMapping("/employee/page/{pageNo}")
    public String getEmployeePage(@PathVariable("pageNo") Integer pageNo, Model model) {
        //获取员工的分页信息
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNo);
        //将分页数据,共享到请求域中
        model.addAttribute("page", page);
        //session.setAttribute("page", page);
        return "employee_list";
    }

    @GetMapping("/to/add")
    public String getToAdd() {
        return "add";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee) {
        employeeService.save(employee);
//        Object obj = session.getAttribute("page");
//        System.out.println(obj);
//        Method getPages = obj.getClass().getMethod("getPages");
//        Integer lastPageNo = (Integer) getPages.invoke(obj);
        PageInfo<Employee> page = employeeService.getEmployeePage(1);
        int pages = page.getPages();
        return "redirect:employee/page/" + pages;
    }


    @DeleteMapping("/employee/{pageNum}/{empId}")
    public String deleteEmployee(@PathVariable("pageNum") Integer pageNum, @PathVariable("empId") Integer empId) {
        employeeService.deleteEmployee(empId);
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        if (page.getPages() != 1 && page.getSize() == 0) {
            pageNum--;
        }
        return "redirect:../page/" + pageNum;
    }

    @GetMapping("/employee/{pageNum}/{empId}")
    public String getToUpdate(@PathVariable("pageNum") Integer pageNum, @PathVariable("empId") Integer empId, ModelMap modelMap) {
        Employee emp = employeeService.getEmployeeById(empId);
        modelMap.addAttribute("pageNum", pageNum);
        modelMap.addAttribute("emp", emp);
        return "update";
    }

    @PutMapping("/employee/{pageNum}")
    public String updateEmployee(@PathVariable("pageNum") Integer pageNum, Employee employee, ModelMap modelMap) {
        employeeService.updateEmployee(employee);
        return "redirect:/employee/page/" + pageNum;
    }
}
