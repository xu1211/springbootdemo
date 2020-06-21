package com.example.springboot.springbootdemo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.springboot.springbootdemo.bean.User;
import com.example.springboot.springbootdemo.mapper.UserMapper;

@Controller
public class RESTUserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/user")
    public String listUser(Model m) throws Exception {
        System.out.println("查询全部用户");
        List<User> us = userMapper.findAll();
        m.addAttribute("us", us);
        return "RESTlistUser";
    }

    @GetMapping("/user/{id}")
    public String editUser(@PathVariable("id") int id, Model m) throws Exception {
        System.out.println("查询单个用户" + id);
        User c = userMapper.get(id);
        m.addAttribute("c", c);
        return "RESTeditUser";
    }

    @PostMapping("/user")
    public String addUser(User c) throws Exception {
        System.out.println("新增用户" + c);
        userMapper.save(c);
        return "redirect:user";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(User c) throws Exception {
        System.out.println("删除用户" + c);
        userMapper.delete(c.getId());
        return "redirect:/user";
    }

    @PutMapping("/user")
    public String updateUser(User c) throws Exception {
        System.out.println("修改用户" + c);
        userMapper.update(c);
        return "redirect:user";
    }
}
