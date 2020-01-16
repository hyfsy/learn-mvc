package com.hyf.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hyf.mvc.validation.group.ValidationGroup1;
import com.hyf.mvc.validation.group.ValidationGroup2;
import com.hyf.mvc.validation.pojo.Message;
import com.hyf.mvc.validation.pojo.MessageCustom;
import com.hyf.mvc.validation.pojo.MessageGroup;

@Controller
@RequestMapping("/validation")
public class ValidationController
{

    /**
     * 在参数前添加 @Validated, 在参数后添加BindingResult对象，接收校验错误信息
     * <p>
     * 注意：@Validated 和 BindingResult 是配对出现的，并且形参顺序固定（一前一后）
     */
    @RequestMapping("/testValidation")
    public String testValidation(@Validated Message msg, BindingResult bindingResult, Model model) {

        String result = printlnError(bindingResult);
        if (result != null) {
            return result;
        }

        // ......

        return "success";
    }

    /**
     * 指定当前 msg 对象使用在 Group1 中的所有校验规则
     */
    @RequestMapping("/testValidationGroup1")
    public String testValidationGroup1(@Validated(value = {ValidationGroup1.class }) MessageGroup msgGroup, BindingResult bindingResult) {

        String result = printlnError(bindingResult);
        if (result != null) {
            return result;
        }

        // ......

        return "success";
    }

    /**
     * 指定当前 msg 对象使用在 Group2 中的所有校验规则
     */
    @RequestMapping("/testValidationGroup2")
    public String testValidationGroup2(@Validated(value = {ValidationGroup2.class }) MessageGroup msgGroup, BindingResult bindingResult) {

        String result = printlnError(bindingResult);
        if (result != null) {
            return result;
        }

        // ......

        return "success";
    }

    @RequestMapping("/testCustomValidation")
    public String testCustomValidation(@Validated MessageCustom messageCustom, BindingResult bindingResult) {

        System.out.println(bindingResult.getModel());
        String result = printlnError(bindingResult);
        if (result != null) {
            return result;
        }

        // ......

        return "success";
    }

    /**
     * 方便输出错误信息
     */
    private String printlnError(BindingResult bindingResult) {

        // 判断是否有错误信息
        if (bindingResult.hasErrors()) {
            System.out.println("错误数量："+bindingResult.getErrorCount());
            // 获取所有错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                System.out.println(objectError.getDefaultMessage());
            }
            // 返回错误页面
            return "error";
        }
        return null;
    }
}
