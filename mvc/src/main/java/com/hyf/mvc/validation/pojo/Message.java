package com.hyf.mvc.validation.pojo;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 测试校验器用 bean
 */
public class Message {

    // 没有message会自动使用 Hibernate 自定义的 message
    @NotBlank(message = "{msg.notnull}")
    private String author;

    @Size(min = 5, max = 16, message = "{msg.size}")
    private String info;

    @NotNull
    @Valid //包含此注解 测试验证级联属性
    private MessageCascade messageCascade;

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

    public MessageCascade getMessageCascade() {
        return messageCascade;
    }

    public void setMessageCascade(MessageCascade messageCascade) {
        this.messageCascade = messageCascade;
    }
}
