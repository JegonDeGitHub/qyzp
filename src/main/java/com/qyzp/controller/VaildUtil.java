package com.qyzp.controller;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VaildUtil {
    @PostMapping("/loginCheck")//注册用户名验证
    public int loginCheck(String uname) {
        boolean tel  = true;//是数字
        for(int i=uname.length()-1;i>=0;i--){
            if(uname.charAt(i)=='@'){
                return 1;
            }else if( !Character.isDigit(uname.charAt(i)) ){ //不是数字
                tel = false;
            }
        }
        if(tel){
            return 2;
        }
        return 0;
    }

    public static boolean isPhone(String str) {
        try {
            long num = Long.valueOf(str);//转换成长整形
            //1E10 = 1*10^10 ,电话号码不能2开头
            if((str.charAt(0)=='1') && num<2E10){ return true; }
        }catch (NumberFormatException e){
            //return false;
        }
        return false;
    }

    public static boolean isPhone2(String str) {
        String regExp = "^1\\d{10}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }


    public static boolean isEmail(String str) {
        int atIndex = str.indexOf('@');
        if(atIndex<=0) { return false; }
        int dotIndex = str.indexOf('.');
        if((dotIndex-1)<=atIndex
                || (dotIndex+1)==str.length()) {
            return false;
        }
        char[] chars = str.toCharArray();
        for(int i=0;i<chars.length;i++) {
            char c = chars[i];
            if(i==atIndex || i==dotIndex) continue;
            if(c>='0' && c<='9') continue;
            if(c>='A' && c<='Z') continue;
            if(c>='a' && c<='z') continue;
            return  false;
        }
        return true;
    }

    public static boolean isEmail2(String str) {
        String regExp = "^[0-9A-Za-z]+@[0-9A-Za-z]+.[0-9A-Za-z]+$";
        Matcher m = Pattern.compile(regExp).matcher(str);
        return  m.matches();
    }

    public static void main(String[] args) {
        String str = "";
        boolean flag = VaildUtil.isPhone(str);
        System.out.println("flag:"+flag);
    }

}
