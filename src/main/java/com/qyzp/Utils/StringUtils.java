package com.qyzp.Utils;

public class StringUtils {
    //判断字符串是否为空
    public static boolean isEmpty(String str) {
        return str==null || str.length()==0;//判断字符串是否为空（null，空字符串)
    }

    //是否不为空
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
//        return str!=null && str.length()!=0;
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().length()==0;//去除前后空格后的字符串如果还为空
    }


}
