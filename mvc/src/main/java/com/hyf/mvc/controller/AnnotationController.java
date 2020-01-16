package com.hyf.mvc.controller;

import com.hyf.mvc.pojo.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.xml.bind.annotation.XmlRootElement;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@ControllerAdvice
@RequestMapping("annotation")
@SessionAttributes("name")
public class AnnotationController {

    /**
     * 测试 RequestBody、ResponseBody 注解
     */
    @RequestMapping("/testRequestBodyAndResponseBody")
    @ResponseBody
    public User testRequestBodyAndResponseBody(@RequestBody String body) {
        System.out.println(body);
        User user = new User();
        user.setName("张思");
        user.setAge(23);
        return user;
    }

    /**
     * 测试 PathVariable 注解(占位符，用于Restful风格开发)
     */
    @RequestMapping(value = "/testVariable/{variable}", method = RequestMethod.POST)
    public String testPathVariable(@PathVariable("variable") Integer id) {
        System.out.println(id);
        return "redirect:/pages/success.html";// 返回页面的所有代码
    }

    /**
     * 测试 RequestParam 注解
     */
    @RequestMapping("testRequestParam")
    public String testRequestParam(@RequestParam("name") String changeName) {
        System.out.println(changeName);
        return "success";
    }

    @RequestMapping("testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept") String accept) {
        System.out.println(accept);
        return "success";
    }

    @RequestMapping("testCookieValue")
    public String testCookieValue(@CookieValue(value = "name") String name) {
        System.out.println(name);
        return "success";
    }

    /**
     * 测试 SessionAttributes 接口 Set
     * Model 是一个接口
     * 会把设置好的值存入 request 对象中
     */
    @RequestMapping("testSetSessionAttributes")
    public String testSetSessionAttributes(Model model) {
        // 通过 Model 添加到 Session
        model.addAttribute("name", "一金额");
        return "forward:/annotation/testGetSessionAttributes";
    }

    /**
     * 测试 SessionAttributes 接口 Get
     * ModelMap 继承自 LinkedHashMap
     * 底层还是会到request中取值
     */
    @RequestMapping("testGetSessionAttributes")
    public String testGetSessionAttributes(ModelMap model, SessionStatus sessionStatus) {
        // 通过 ModelMap 从 Session 取值
        String name = (String) model.get("name");
        System.out.println(name);
        //使 SessionAttributes 中的值都失效
        sessionStatus.setComplete();

        // 请求转发后到这 会结束
        if (name == null) {
            return "success";
        }
        return "forward:/annotation/testGetSessionAttributes";
    }

    /**
     * 测试 ModelAttribute 注解在方法上注释，带返回值
     */
//    @ModelAttribute
//    public User testModelAttribute() {
//        User user = new User();
//        user.setName("123test");
//        user.setPrice(1.111);
//        return user;
//    }
    @RequestMapping("testModelAttribute")
    public String testGetModelAttribute(User user) {
        System.out.println(user);
        return "success";
    }

    /**
     * 测试 ModelAttribute 注解在方法上注释，不带返回值
     */
//    @ModelAttribute
//    public void testModelAttributeNoReturn(Map<String, User> saveMap) {
//        User user = new User();
//        user.setName("123test");
//        user.setBirthday(new Date());
//        saveMap.put("modelAttribute", user);
//    }
    @RequestMapping("testModelAttributeNoReturn")
    public String testGetModelAttributeNoReturn(@ModelAttribute("modelAttribute") User user) {
        System.out.println(user);
        return "success";
    }

    @ModelAttribute("toRequest")
    public String testGetModelAttributeNoReturn() {
        return "放入request，返回到前台";
    }


    @RequestMapping("testDataReturnToRequest")
    public String testDataReturnToRequest() {
        return "success";
    }

    // 多个测试用，结果：参数绑定时会收集 所有带此注解的方法
    @InitBinder
    public void customDateEditorBinder(WebDataBinder webDataBinder) {
        // 自定义编辑前台对应的属性
        webDataBinder.registerCustomEditor(Date.class, "date", new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }


    // ===============================================测试失败===============================================


    @RequestMapping(value = "/testMatixVariable/{str}", method = RequestMethod.GET)
    public String testMatixVariable(@MatrixVariable("id") String id) {
        System.out.println(id);
        return "success";
    }

    @RequestMapping("/testMatixVariable/{str1}/mid/{str2}")
    public String testMatixVariable2(@MatrixVariable(pathVar = "str2", value = "id") String id1,
                                     @MatrixVariable(pathVar = "str1", value = "id") String id2) {
        System.out.println(id1);
        System.out.println(id2);
        return "success";
    }

    //请求URL: GET file2/pets/42;q=11;r=22
    @RequestMapping(value = "/pets/{petId}", method = RequestMethod.GET)
    public String findPet(@PathVariable String petId, @MatrixVariable int q) {
        System.out.println(petId);// petId == 42
        System.out.println(q);// q == 11
        return "success";
    }

    /**
     * 将返回值对象转换为xml类型的，对象要加{@link XmlRootElement}，别忘了要加{@link ResponseBody}
     */
    @RequestMapping("testXmlRootElementResolvePojo")
    @ResponseBody
    public User testXmlRootElementResolvePojo(){
        return new User("测试1号",18, new Date(), 199.9);
    }

}
