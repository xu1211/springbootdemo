package com.example.springboot.springbootdemo.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Controller返回会根据配置进行视图重定向
 *
 * @RestController返回只是字符串
 */
@RestController
public class hellWord {

    // 返回字符串"Hello Spring Boot!"
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }
}
