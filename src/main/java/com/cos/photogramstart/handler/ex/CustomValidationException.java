package com.cos.photogramstart.handler.ex;

import java.util.Map;

public class CustomValidationException extends RuntimeException{

    private static final long serialVersionUIL = 1L;


    private int code;
    private String message;
    private Map<String, String> errorMap;

    public CustomValidationException (int code,String message, Map<String, String> errorMap){
        super(message);
        this.code = code;
        this.errorMap=errorMap;
    }
    public Map<String,String> getErrorMap(){
        return errorMap;
    }


}
