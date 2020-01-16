package com.hyf.oldmvc.interceptor;

import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 测试老的拦截器
 */
public class testOldInterceptorController implements HttpRequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("方法执行");
        request.getRequestDispatcher("/pages/success.html").forward(request, response);
    }
}
