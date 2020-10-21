package com.antiy.demo.thread.example.shunxu1;

/**
 * @Author ygh
 * @Description
 * @Date 2020/10/15
 */
public class Test1 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 5/0;

                System.out.println("1");
            }
        }).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1");
    }
}
