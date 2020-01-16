package com.hyf.i18n.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class I18NController {

    @RequestMapping(value = "/submitLogin")
    public String submitLogin(Model model) {

        model.addAttribute("testAttr","测试请求参数");

        return "show";
    }
}
