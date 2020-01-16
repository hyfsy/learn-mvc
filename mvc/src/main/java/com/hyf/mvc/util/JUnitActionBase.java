package com.hyf.mvc.util;

import org.junit.BeforeClass;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试方法，只要调用{@link #excuteAction}方法就可以测试了，传入的request要带请求url（参数）
 * <p>
 * 导包：spring-test、junit4
 */
public class JUnitActionBase {

    private static HandlerMapping handlerMapping;
    private static HandlerAdapter handlerAdapter;

    /**
     * 读取spring3 MVC配置文件
     * <p>
     * #@ContextConfiguration
     * <p>
     * # 一个JUnit4的单元测试用例执行顺序为：
     * # @BeforeClass -> @Before -> @Test -> @After -> @AfterClass;
     */
    @BeforeClass
    public static void setUp() {
        if (handlerMapping == null) {
            String[] configs = {"file:src/springConfig/springMVC.xml"};
            XmlWebApplicationContext context = new XmlWebApplicationContext();
            context.setConfigLocations(configs);
            MockServletContext msc = new MockServletContext();
            context.setServletContext(msc);
            context.refresh();
            msc.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, context);
            handlerMapping = context.getBean(RequestMappingHandlerMapping.class);
            handlerAdapter = (HandlerAdapter) context.getBean(context.getBeanNamesForType(RequestMappingHandlerAdapter.class)[0]);
        }
    }

    /**
     * 执行request对象请求的action
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ModelAndView excuteAction(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HandlerExecutionChain chain = handlerMapping.getHandler(request);
        if (chain == null) {
            throw new NullPointerException("null execution chain");
        }
        return handlerAdapter.handle(request, response, chain.getHandler());
    }

}
