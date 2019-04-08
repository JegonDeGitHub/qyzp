package com.qyzp.annotation.resolver;

import com.qyzp.Exception.BadRequestException;
import com.qyzp.annotation.ValidParam;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ValueConstants;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class ValidParamHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override//验证参数有没有包含这个注解
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasMethodAnnotation(ValidParam.class);
    }
    //没有就不进入↓下一个方法了

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        ValidParam validParam = parameter.getParameterAnnotation(ValidParam.class);//获取到这个注解
        String name = validParam.name();//获取注解的值
        if(name.length() == 0){name = parameter.getParameterName();}//值为空 获取注解原来的name
        String str = webRequest.getParameter(name);//从请求中找到与注解绑定字段的name的值
        //请求没有参数 就给一个默认值
        if(str ==null && !ValueConstants.DEFAULT_NONE.equals(validParam.defaultValue())){
            str = validParam.defaultValue();
        }
        //参数是否为必须的 ，但请求中参数为空 就抛出异常(没有请求属性异常)
        if (validParam.required() && str == null) {
            throw new MissingServletRequestParameterException(name,
                    parameter.getNestedParameterType().getSimpleName());

        }
        //注解有一个参数 接收的参数指定不能为空白
        if (validParam.notblank()) {
            if (str==null || str.trim().length()==0) {
                throw  new BadRequestException(name+"不能为空");
            }
        }
        return str;
    }
}
