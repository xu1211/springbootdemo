package com.example.springboot.springbootdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Controller返回会根据配置进行视图重定向
 *
 * @RestController返回只是字符串
 */
@Controller
public class hellThymeleaf {

    /*
        @RequestMapping("/hellothymeleaf")
        跳转到 thymeleaf.html 并带上数据 "name"="My thymeleaf"
    */
    @RequestMapping("/hellothymeleaf")
    public String hello(Model m) {
        m.addAttribute("name", "My thymeleaf");
        return "thymeleaf";
    }
}
