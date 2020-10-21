package com.antiy.demo.thread.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author ygh
 * @Description 类对象和实例对象
 * @Date 2020/9/15
 */
public class SyncReenDemo3 {

    public synchronized void m2() {
        System.out.println(Thread.currentThread().getName() + "m2======================");
    }

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + "m1======================");
    }

    public static void main(String[] args) {
        SyncReenDemo3 syncReenDemo3 = new SyncReenDemo3();
        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 60, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024));
//        for (int i = 0; i < 100; i++) {
//            executorService.submit(new Runnable() {
//                @Override
//                public void run() {
//                    syncReenDemo3.m1();
//                    m2();
//                }
//            });
//        }
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    syncReenDemo3.m1();

                }
            }).start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    syncReenDemo3.m2();

                }
            }).start();
        }

    }
}
