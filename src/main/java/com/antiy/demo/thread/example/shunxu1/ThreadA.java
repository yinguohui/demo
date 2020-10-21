package com.antiy.demo.thread.example.shunxu1;

/**
 * @Author ygh
 * @Description
 * @Date 2020/1/8
 */
public class ThreadA extends Thread {
    private String name;

    public ThreadA(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
        }
    }
}
