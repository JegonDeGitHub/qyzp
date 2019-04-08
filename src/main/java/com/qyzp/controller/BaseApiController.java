package com.qyzp.controller;

import com.qyzp.Exception.BadRequestException;
import com.qyzp.bean.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

public abstract class BaseApiController {

    public Map<String,Object> resp(int code,String msg,Object data) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",code);
        map.put("msg",msg);
        map.put("data",data);
        return  map;
    }

    public Map<String,Object> respInsertSuccess(Integer id) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        return  resp(200,"添加成功",map);
    }



    public Map<String,Object> respUserList(List<User> list) {
        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        return  resp(200,"查询User全部成功",map);
    }



    public Map<String,Object> respData(Object data) {
        return resp(200,"null",data);
    }

    public Map<String,Object> respUpdateSuccess() {
        return  resp(200,"修改成功",null);
    }

    public Map<String,Object> respDelSuccess(Object object) {
       return resp(200,"删除成功",null);
    }

    public Map<String,Object> request(int code,String msg,Object data) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",code);
        map.put("msg",msg);
        map.put("data",data);
        return  map;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//服务器异常
    @ExceptionHandler(Exception.class)
    public  Map<String,Object> exceptionHandler(Exception ex) {
        ex.printStackTrace();
        return  resp(500,ex.getMessage());
    }

    public Map<String,Object> resp(int code,String msg) {
        return resp(code,msg,null);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)//请求异常
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Map<String,Object> missingServletRequestHandler(MissingServletRequestParameterException ex) {
        return resp(400,ex.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)//请求异常
    public  Map<String,Object> exceptionHandler(BadRequestException ex) {
        ex.printStackTrace();
        return  resp(ex.getCode(),ex.getMessage());
    }


}
