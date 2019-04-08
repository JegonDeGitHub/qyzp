package com.qyzp.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.ValueConstants;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)//该注解使用类型
@Retention(RetentionPolicy.RUNTIME)//注解生命周期（RUNTIME代表运行时通过反射机制获取注解信息）
@Documented//指示将此注解包含在javadoc中
public @interface ValidParam {
    @AliasFor("name")
    String value() default "";//注解值

    @AliasFor("value")
    String name() default "";//注解名字

    boolean required() default true;//使用该注解请求时不可以省略的参数：是否开启这个功能？true

    String defaultValue() default ValueConstants.DEFAULT_NONE;//默认值 默认没有

    boolean notblank() default false;//能不能为空白

}
