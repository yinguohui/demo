package com.antiy.demo.other;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/5
 */
public class MyException extends Exception{
    public MyException(String message) {
        super(message);
    }
    public MyException() {
    }

    public MyException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public MyException(Throwable throwable) {
        super(throwable);
    }

    public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
