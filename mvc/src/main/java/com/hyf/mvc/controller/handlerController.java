package com.hyf.mvc.controller;

import com.hyf.mvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@SessionAttributes
public class handlerController {

    /**
     * 很有深度
     */
    @RequestMapping("/testHandlerFlow")
    public ModelAndView testHandlerFlow(@Validated User user1, BindingResult result2) {
        System.out.println(result2.getErrorCount());
        result2.getAllErrors().forEach((error) -> System.out.print(error.getDefaultMessage()));
        return new ModelAndView("success", "test", "testmavreturnvalue");
    }

    @InitBinder
    public void testBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("name", "birthday");
    }

    @ModelAttribute
    public User initUser() {
        return new User("张三", 18, new Date(), 123.456d);
    }

}
