package com.hyf.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interceptor")
public class InterceptorController {

    @RequestMapping("/powerInterceptor")
    public String testInterceptor(){
        System.out.println("执行方法中。。。");
        return "success";
    }
}
