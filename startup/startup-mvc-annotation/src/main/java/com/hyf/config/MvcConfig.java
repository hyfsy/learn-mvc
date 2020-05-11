package com.hyf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 子容器测试
 *
 * @author baB_hyf
 * @date 2020/05/10
 */
@EnableWebMvc
@Configuration
@ComponentScan("com.hyf.controller")
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 资源处理器 处理静态资源
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/").addResourceLocations("/pages/**");
    }

    /**
     * 启用默认servlet
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable("default");
    }

    /**
     * 视图解析器
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/pages/");
        viewResolver.setSuffix(".html");
        registry.viewResolver(viewResolver);
    }
}
