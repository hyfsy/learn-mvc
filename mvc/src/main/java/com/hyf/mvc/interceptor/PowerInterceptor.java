package com.hyf.mvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义拦截器
 */
public class PowerInterceptor implements HandlerInterceptor {

    /**
     * 执行请求方法前 执行
     * <p>
     * 主要用于权限控制，日志，事务等
     *
     * @return 允许执行该请求，返回 true , 否则拦截该请求，返回 false
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("请求通过.");
        return true;
    }

    /**
     * 执行请求方法后 执行
     * <p>
     * 主要用于视图或请求的修改
     * <p>
     * 此处可请求转发到其他页面（即使控制层返回页面，也不会显示，但会渲染，例如 jsp 页面上打印一句话会被执行）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws ServletException, IOException {
        // 返回到 exception页面，就不会再返回方法中的success页面了
//        request.getRequestDispatcher("/pages/exception.html").forward(request, response);
        System.out.println("请求方法执行完毕..");
    }

    /**
     * 返回视图后 执行
     * <p>
     * 主要用于释放资源
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("渲染视图结束...");
    }
}
