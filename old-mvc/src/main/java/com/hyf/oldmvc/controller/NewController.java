package com.hyf.oldmvc.controller;

import com.hyf.oldmvc.validation.Message;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class NewController {

    @RequestMapping("/testNewController1")
    public String testNewController() {

        System.out.println("执行注解方法");

        return "success";
    }

    /**
     * 测试转换器的旧配置
     */
    @RequestMapping("/testOldConverter")
    public String testNewController(Date date) {

        System.out.println(date);
        return "success";
    }

    /**
     * 测试验证器的旧配置
     */
    @RequestMapping("/testOldValidation")
    public String testOldValidation(@Validated Message message, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            return "success";
        }

        List<ObjectError> allErrors = bindingResult.getAllErrors();
        for (ObjectError error : allErrors) {
            System.out.println("string: " + error.toString());
            System.out.println("object_name: " + error.getObjectName());
            System.out.println("arguments: " + Arrays.toString(error.getArguments()));
            System.out.println("code: " + error.getCode());
            System.out.println("codes: " + Arrays.toString(error.getCodes()));
            System.out.println("class: " + error.getClass());
            System.out.println("default_message: " + error.getDefaultMessage());
        }
        return "error";

    }

    /**
     * 测试 Rest 风格 url 的旧配置
     */
    @RequestMapping(value = "/testOldRest/{id}", method = RequestMethod.DELETE)
    public String testOldRest(@PathVariable("id") String id){

        System.out.println(id);
        return "success";
    }

}
