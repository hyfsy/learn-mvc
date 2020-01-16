package com.hyf.mvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 伪全局异常处理类
 * <p>
 * 对应controller中找不到指定异常，会查找 @ControllerAdvice 注解标记的类，
 * 在 @ExceptionHandler 标记的方法中查找处理对应异常的方法
 * <p>
 * 每个方法指定 @ExceptionHandler 注解
 */
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler
    public String exception2ThisMethod(Exception ex) {
        return "error";
    }

    /**
     * 对应类型的异常不会走全局的方法处理
     */
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public String testExceptionHandler() {
        return "error";
    }


}
