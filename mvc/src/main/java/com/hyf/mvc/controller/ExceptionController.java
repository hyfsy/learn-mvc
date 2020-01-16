package com.hyf.mvc.controller;

import com.hyf.mvc.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/exception")
public class ExceptionController {

    @RequestMapping("/sendException")
    public String testHandlerException() throws BusinessException {
        //假装有异常
        throw new BusinessException("测试异常");
    }

    @RequestMapping("/sendCatchException")
    public String testCatchHandlerException() throws ArrayIndexOutOfBoundsException {
        //假装有数组下标越界异常
        throw new ArrayIndexOutOfBoundsException("测试数组下标越界异常");
    }

    @RequestMapping("handlerException")
    public String handlerException(HttpServletRequest request) {
        String message = (String) request.getAttribute("message");

        //异常信息会通过 ModelAndView 放入request对象中
        System.out.println(message);

        return "success";
    }

    /**
     * 方法级别的处理异常
     * <p>
     * 指定当前controller产生错误的处理方法（可指定对应异常）
     */
    @ExceptionHandler
    public String exception2ThisMethod(Exception ex) {
        return "error";
    }

    /**
     * ResponseStatusExceptionResolver 处理此类异常
     * <p>
     * 该注解可放在方法上，也可放在异常类上
     * <p>
     * 不管该方法是否抛异常，都会403...
     */
    @ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "测试403拒绝报错页面")
    @RequestMapping("/testResponseStatus")
    public String testResponseStatus() {
        return "error";
    }

}
