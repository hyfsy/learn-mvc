package com.hyf.mvc.controller;

import com.hyf.mvc.pojo.User;
import com.hyf.mvc.propertyeditor.CustomUserPropertyEditor;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PropertyEditorController {

    @RequestMapping("/testCustomPropertyEditor")
    public String testCustomPropertyEditor(User user1) {

        BeanWrapperImpl bw = new BeanWrapperImpl(false);
        User user = new User();
        bw.setWrappedInstance(user);
        bw.setPropertyValue("user", "testuser;99");
        System.out.println(bw);

        return "succcess";
    }

    @InitBinder
    public void binderPropertyEditor(WebDataBinder webDataBinder) {
        // 自定义的属性编辑器需要在WebDataBinder中进行注册
        webDataBinder.registerCustomEditor(User.class, new CustomUserPropertyEditor());
    }

}
