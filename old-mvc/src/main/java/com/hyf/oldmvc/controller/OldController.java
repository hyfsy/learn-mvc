package com.hyf.oldmvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 如果配置了SimpleControllerHandlerAdapter,要实现Controller接口来编写Handler对象的方法
 * 一个Controller类为一个Handler对象
 */
public class OldController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("实现了 Controller 接口执行 handler 方法中.....");

        return new ModelAndView("success", "message", "成功执行请求方法");
    }

}
