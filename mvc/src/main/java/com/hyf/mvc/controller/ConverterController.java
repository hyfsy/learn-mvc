package com.hyf.mvc.controller;

import com.hyf.mvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/converter")
public class ConverterController {

    @RequestMapping("/string2date")
    public String stringToDate(User user) {
        System.out.println(user);
        return "success";
    }

}
