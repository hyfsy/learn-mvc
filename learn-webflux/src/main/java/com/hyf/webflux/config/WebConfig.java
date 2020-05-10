package com.hyf.webflux.config;

import com.hyf.webflux.handler.HelloHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.support.HandlerFunctionAdapter;
import org.springframework.web.servlet.function.support.RouterFunctionMapping;

/**
 * @author baB_hyf
 * @date 2020/04/15
 */
//@Configuration
public class WebConfig {

    @Bean
    public RouterFunctionMapping routerFunctionMapping(){
        return new RouterFunctionMapping();
    }

    @Bean
    public HandlerFunctionAdapter handlerFunctionAdapter(){
        return new HandlerFunctionAdapter();
    }

    @Bean
    public RouterFunction router(HelloHandler handler) {
        return RouterFunctions.route()
                .GET("/hello", handler::hello)
                .POST("/createPerson", RequestPredicates.accept(MediaType.APPLICATION_JSON), handler::createPerson)
                .build();
    }

}
