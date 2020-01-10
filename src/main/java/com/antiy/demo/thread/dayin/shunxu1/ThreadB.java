package com.antiy.demo.thread.dayin.shunxu1;

/**
 * @Author ygh
 * @Description
 * @Date 2020/1/8
 */
public class ThreadB extends Thread{
    private String name;

    public ThreadB(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
    }
}
