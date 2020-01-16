package com.hyf.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ViewController {

    /**
     * 不需要编写页面，直接请求该路径
     */
    @RequestMapping("/testCustomView")
    public String testCustomView(){

        // 返回的视图名为自定义视图类名，第一个字母小写
        return "customView";
    }

    /**
     * 重定向，请求参数不消失
     */
    @RequestMapping("/testRedirectAttributes")
    public String testRedirectAttributes(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("msg", "重定向请求参数不消失");
        return "redirect:/testCustomView";
    }
}
