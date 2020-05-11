package com.hyf.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * 注解方式初始化容器
 * <p>
 * 继承 {@code AbstractDispatcherServletInitializer} 自定义容器初始化
 *
 * @author baB_hyf
 * @date 2020/05/10
 */
public class AppContainerInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 根/父容器
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    /**
     * Servlet容器
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    /**
     * DispatcherServlet的请求映射路径
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 设置字符编码过滤器
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        return new Filter[]{encodingFilter};
    }
}
