package com.hyf.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

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

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

        String filePath = "E:\\file\\";
        long maxFileSize = (long)(5 * Math.pow(2, 20));
        long maxRequestSize = (long)(10 * Math.pow(2, 20));
        int fileSizeThreshold = 0;

        registration.setMultipartConfig(new MultipartConfigElement(filePath, maxFileSize, maxRequestSize, fileSizeThreshold));
    }
}
