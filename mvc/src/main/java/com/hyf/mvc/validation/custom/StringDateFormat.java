package com.hyf.mvc.validation.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
// 指定实际进行校验的校验器，该校验器是自己写的且必须实现ConstraintValidator接口
@Constraint(validatedBy = StringDateFormatValidator.class)
public @interface StringDateFormat {

    /**
     * 验证前台传过来的时间格式是否匹配
     */
    String regex() default "yyyy-MM-dd HH:mm:ss";

    /**
     * 自定义注解如果要和 Hibernate 的校验规则配套使用，注解中必须要存在下面三个属性
     * <p>
     * 这是 Hibernate Validation框架要求的
     * <p>
     * 都必须有默认值
     */
    String message() default "{com.hyf.mvc.validation.custom.StringDate.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
