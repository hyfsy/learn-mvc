package com.hyf.mvc.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串->日期转换器
 */
public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = df.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
