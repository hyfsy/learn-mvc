package com.hyf.oldmvc.controller;

import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 如果配置了HttpRequestHandlerAdapter,要实现HttpRequestHandler接口来编写Handler对象的方法
 * <p>
 * 此种方式可以指定response修改定义响应内容，比如json数据
 */
public class OldController2 implements HttpRequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("实现了 HttpRequestHandler 接口执行 handler 方法中.....");

        request.setAttribute("message", "成功执行请求方法");
        request.getRequestDispatcher("/pages/success.html").forward(request, response);
    }

}
