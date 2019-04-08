package com.qyzp.bean.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)//将默认返回的ADMIN转换成json形式（value：1，desc：管理员）
public enum RoleType {
    ADMIN(1,"管理员"),
    GUEST(2,"游客"),
    JOBSEEK(3,"求职者"),
    COMPANY(4,"公司");

    private int value;
    private String desc;

    RoleType(int value,String desc) {
        this.value = value;
        this.desc = desc;
    }

    //传递整数参数 返回 对应的RoleType对象 Ex:传递一个1，返回一个ADMIN（1，管理员）遍历完都没有返回null
    public static RoleType valueOf(int value) {
        for(RoleType type:values()) {
            if (type.value == value) { return type; }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "RoleType{" +
                "value=" + value +
                ", desc='" + desc + '\'' +
                '}';
    }
}
