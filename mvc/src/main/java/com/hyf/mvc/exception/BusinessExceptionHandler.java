package com.hyf.mvc.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 配置文件中绑定异常
 * 控制层抛出异常后会被捕捉到并执行方法，再返回给视图解析器
 */
public class BusinessExceptionHandler implements HandlerExceptionResolver {

    /**
     * @param request  请求对象
     * @param response 响应对象
     * @param handler  处理器适配器处理的handler对象
     * @param ex       对应的异常对象
     * @return 可以设置返回指定的页面，并传递异常信息
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        BusinessException be;

        if(ex instanceof BusinessException){
            be = (BusinessException)ex;
        }else{
            be = new BusinessException("系统产生错误...");
        }

        System.out.println("系统出现异常");

        return new ModelAndView("error", "message", be.getMessage());
    }

}
