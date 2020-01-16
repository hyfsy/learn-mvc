package com.hyf.mvc.view;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * 自定义视图，实现 View 接口
 * <p>
 * 用 @Component 注解标识
 * 因为会自动从 IOC 容器中获取该视图，所有需要事先放入 IOC 容器中
 */
@Component
public class CustomView implements View {
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 防止乱码
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("自定义视图<br />时间：" + new Date());
    }
}
