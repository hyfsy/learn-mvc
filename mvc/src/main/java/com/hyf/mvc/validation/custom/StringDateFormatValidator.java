package com.hyf.mvc.validation.custom;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * ConstraintValidator<?, ?>
 * 接口中第一个类型为校验对应的注解，第二个类型为前台传过来的参数的类型
 */
public class StringDateFormatValidator implements ConstraintValidator<StringDateFormat, String> {

    private String dateRegex;

    /**
     * 通过此方法可以获取到注解中的值
     *
     * @param sdf 验证的注解
     */
    @Override
    public void initialize(StringDateFormat sdf) {
        // 通过注解 获取验证的时间格式
        this.dateRegex = sdf.regex();
    }

    /**
     * 真正核心的验证方法
     *
     * @param value   前台转过来的请求参数
     * @param context 通过 ConstraintValidatorContext 可以对错误信息进行修改
     * @return 如果验证成功，返回 true，否则返回 false
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

//        context.disableDefaultConstraintViolation();// 禁用 message 的值
//        context.getDefaultConstraintMessageTemplate();// 获取消息字符串
//        context.buildConstraintViolationWithTemplate("测试增加消息").addConstraintViolation();// 增加错误消息
//        ......

        try {
            new SimpleDateFormat(dateRegex).parse(value);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
