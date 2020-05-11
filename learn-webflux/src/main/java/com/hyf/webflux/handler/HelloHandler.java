package com.hyf.webflux.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * @author baB_hyf
 * @date 2020/04/15
 */
@Component
public class HelloHandler {

    /**
     * 跳转页面在此处不适合，可以使用 SpringMVC
     */
    public ServerResponse hello(ServerRequest request) {
        System.out.println("hello webflux: " + request.path());
        return ServerResponse.ok().body("success!!!");
    }

    public ServerResponse createPerson(ServerRequest request) {
        System.out.println("createPerson...");
        return ServerResponse.ok().build();
    }
}
