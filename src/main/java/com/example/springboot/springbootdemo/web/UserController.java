package com.example.springboot.springbootdemo.web;

import com.example.springboot.springbootdemo.mapper.UserMapper;
import com.example.springboot.springbootdemo.bean.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/hellothymeleaf")
    public String hello(Model m) {
        m.addAttribute("name", "thymeleaf");
        return "thymeleaf";
    }

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/listUser")
    public String listUser(Model m) throws Exception {
        List<User> us = userMapper.findAll();
        m.addAttribute("us", us);
        return "listUser";
    }

    @RequestMapping("/addUser")
    public String listUser(User c) throws Exception {
        userMapper.save(c);
        return "redirect:listUser";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(User c) throws Exception {
        userMapper.delete(c.getId());
        return "redirect:listUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User c) throws Exception {
        userMapper.update(c);
        return "redirect:listUser";
    }

    @RequestMapping("/editUser")
    public String listUser(int id, Model m) throws Exception {
        User c = userMapper.get(id);
        m.addAttribute("c", c);
        return "editUser";
    }
}
