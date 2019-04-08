package com.qyzp.Exception;

import java.io.IOException;

public class ExceptionTest {
    public static void main(String[] args) throws IOException {
//        throw new Exception();
//        throw  new RuntimeException();
        fun();

    }

    public static void fun() {
//        throw new RuntimeException();
        throw new BadRequestException(400,"请求失败");
    }
}
