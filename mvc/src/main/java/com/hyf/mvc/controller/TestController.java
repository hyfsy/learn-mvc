package com.hyf.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.annotation.Resource;
import javax.annotation.Resources;

@Controller
@RequestMapping("/file2")
public class TestController {

    @Resource(name = "businessExceptionHandler")
    private HandlerExceptionResolver resolver;

    @RequestMapping("/test1")
    public void test1 () {
        System.out.println("test1");
    }

    @GetMapping
    public void test2 () {
        System.out.println("test2");
    }

//    @GetMapping
    public void test3 () {
        System.out.println("test3");
    }

    @RequestMapping("/test4")
    public String test4 () {
        System.out.println(1);
        // 偶然发现，会将 @ModelAttribute 注解返回的对象当做参数传递
        return "redirect:../index.html";
    }

}
