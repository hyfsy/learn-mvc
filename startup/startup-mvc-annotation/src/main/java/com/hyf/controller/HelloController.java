package com.hyf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author baB_hyf
 * @date 2020/05/10
 */
@Controller
public class HelloController {

    @RequestMapping("hello")
    public String hello() {
        return "success";
    }
}
