package com.hyf.mvc.validation.pojo;

import com.hyf.mvc.validation.group.ValidationGroup1;
import com.hyf.mvc.validation.group.ValidationGroup2;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 测试分组校验用 bean
 */
public class MessageGroup {

    // 指定该校验规则放在哪个分组下
    @NotBlank(message = "{msg.notnull}", groups = {ValidationGroup1.class})
    private String author;

    @Size(min = 5, max = 16, message = "{msg.size}", groups = {ValidationGroup2.class})
    private String info;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
