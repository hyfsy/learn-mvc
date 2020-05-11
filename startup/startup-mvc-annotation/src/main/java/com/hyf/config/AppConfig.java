package com.hyf.config;

import com.hyf.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 父容器测试
 *
 * @author baB_hyf
 * @date 2020/05/10
 */
@Configuration
public class AppConfig {

    @Bean
    public Person person() {
        return new Person();
    }
}
