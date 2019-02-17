package com.example.admin.web.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.core.service.user.EmployeeService;
import com.example.persist.entity.user.Employee;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author qmt
 * @since 2019-02-17
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

    @RequestMapping("/list")
    @ResponseBody
    public Object list() {
        return employeeService.list(new QueryWrapper<Employee>());
    }

}
