package com.antiy.demo.exception;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/20
 */
public class MyException extends Exception {
    public MyException() {

    }

    public MyException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        Test test = new Test();
        try {
            test.display(0);
            System.out.println("---------------------");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
