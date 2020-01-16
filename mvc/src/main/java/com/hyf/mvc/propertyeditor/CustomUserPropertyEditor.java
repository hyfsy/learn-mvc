package com.hyf.mvc.propertyeditor;

import com.hyf.mvc.pojo.User;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 自定义属性编辑器
 */
public class CustomUserPropertyEditor extends PropertyEditorSupport {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text.indexOf(';') != -1) {
            String[] data = text.split(";");
            User user = new User();
            for (int i = 0, size = data.length; i < size; i++) {
                String property = data[i];
                switch (i + 1) {
                    case 1:
                        user.setName(property);
                        break;
                    case 2:
                        user.setAge(Integer.valueOf(property));
                        break;
                    case 3:
                        try {
                            user.setBirthday(sdf.parse(property));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 4:
                        user.setPrice(Double.parseDouble(property));
                        break;
                }
            }
            setValue(user);
            return;
        }
        throw new IllegalArgumentException("must split with [;] :" + text);
    }
}
