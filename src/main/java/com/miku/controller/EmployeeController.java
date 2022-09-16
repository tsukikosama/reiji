package com.miku.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.miku.common.R;
import com.miku.entity.Employee;
import com.miku.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.MD5;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;

@RestController
@Slf4j
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("login")
    public R<Employee> login(@RequestBody Employee employee, HttpServletRequest request){
        //获取密码 然后给密码加密
        String password = employee.getPassword();
        //加密后赋值
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        //判断是否有这个账号
        wrapper.eq(Employee::getUsername,employee.getUsername());
        //去数据库中查询
        Employee employee1 = employeeService.getOne(wrapper);
        if(employee1 == null){
            return  R.error("用户不存在");
        }
        //判断密码是否正确
        if(!password.equals(employee1.getPassword())){
            return R.error("密码不正确");
        }
        //判断账户是否被封禁
        if(employee1.getStatus() != 1){
            return R.error("账号被封禁");
        }
        request.getSession().setAttribute("employee",employee.getUsername());
        return R.success(employee1);
    }
    @PostMapping("logout")
    public R<String> logout( HttpServletRequest request){
        request.getSession().removeAttribute("employee");
        return R.success("退出成功");
    }
}
