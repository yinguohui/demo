package com.antiy.demo.exception;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/20
 */
public class Test {
    public void display(int i) throws MyException {
        if (i == 0) {
            throw new MyException("该值不能为0.......");
        } else {
            System.out.println(i / 2);
        }

    }
}