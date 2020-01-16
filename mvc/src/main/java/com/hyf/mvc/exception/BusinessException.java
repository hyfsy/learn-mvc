package com.hyf.mvc.exception;

/**
 * 自定义异常类
 */
public class BusinessException extends Exception {
    private String message;

    public BusinessException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}