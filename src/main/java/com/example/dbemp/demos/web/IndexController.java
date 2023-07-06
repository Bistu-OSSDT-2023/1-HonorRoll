package com.example.dbemp.demos.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//自动跳转，方便
@Controller
public class IndexController {
    @RequestMapping("/")
    public String hello(){
        return "redirect:/page/user-table.html";
    } //重定向
}
