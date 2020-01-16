package com.hyf.mvc.validation.pojo;

import javax.validation.constraints.Min;

/**
 * 测试级联验证用 bean
 */
public class MessageCascade {

    @Min(value = 5, message = "{msg.min}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
