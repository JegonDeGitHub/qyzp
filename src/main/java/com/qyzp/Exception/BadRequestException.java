package com.qyzp.Exception;

public class BadRequestException extends RuntimeException {
    private int code;
    //private String message;

    public BadRequestException( String message) {
        super(message);
    }

    public BadRequestException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {return this.code;}

    public void setCode(int code) {this.code = code;}
}
