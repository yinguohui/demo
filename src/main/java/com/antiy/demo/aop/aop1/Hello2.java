package com.antiy.demo.aop.aop1;

/**
 * @Author ygh
 * @Description
 * @Date 2020/9/4
 */
public class Hello2 implements Hello {
    @Override
    public void sayhello() {
        System.out.println("我是Hello2---我说你好");
    }

    @Override
    public void saybay() {
        System.out.println("我是Hello2---我说再见");
    }
}
