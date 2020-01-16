package com.hyf.mvc.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class OrderInterceptor extends HandlerInterceptorAdapter {

    /**
     * 执行请求方法前 执行
     *
     * @return 允许执行该请求，返回 true , 否则拦截该请求，返回 false
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("请求通过.2");
        return true;
    }

    /**
     * 执行请求方法后 执行
     * 此处可重定向到其他页面（即使控制层返回页面，也不会显示，但会渲染，例如 jsp 页面上打印一句话会被执行）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("请求方法执行完毕..2");
    }

    /**
     * 返回视图后 执行
     * 此方法用于释放资源
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("渲染视图结束...2");
    }
}
