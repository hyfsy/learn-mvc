package com.hyf.mvc.validation.pojo;

import com.hyf.mvc.validation.custom.StringDateFormat;

/**
 * 测试自定义注解 bean
 */
public class MessageCustom {

    @StringDateFormat
    private String dateStr;

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }
}
