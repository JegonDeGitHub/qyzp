package com.qyzp.converter;

import com.qyzp.bean.enums.RoleType;
import org.springframework.core.convert.converter.Converter;

public class StringToRoleType implements Converter<String, RoleType> {
    @Override
    public RoleType convert(String s) {
        return RoleType.valueOf(s);
    }

    //    @Override
//    public RoleType convert(String s) {
//        return RoleType.valueOf(Integer.valueOf(s));
//    }
//
//    @Override
//    public JavaType getInputType(TypeFactory typeFactory) {
//        return null;
//    }
//
//    @Override
//    public JavaType getOutputType(TypeFactory typeFactory) {
//        return null;
//    }


}
