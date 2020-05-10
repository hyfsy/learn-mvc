package com.hyf.webflux.config;

import com.hyf.webflux.handler.HelloHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;

/**
 * @author baB_hyf
 * @date 2020/04/19
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public RouterFunction router(HelloHandler handler) {
        return RouterFunctions.route()
                .GET("/hello", handler::hello)
                .POST("/createPerson", RequestPredicates.accept(MediaType.APPLICATION_JSON), handler::createPerson)
                .build();
    }


}
