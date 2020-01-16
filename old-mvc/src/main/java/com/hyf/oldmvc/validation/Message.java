package com.hyf.oldmvc.validation;


import javax.validation.constraints.NotBlank;

public class Message {

    @NotBlank(message = "{validation.test.name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
