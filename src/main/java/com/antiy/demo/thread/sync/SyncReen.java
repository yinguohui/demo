package com.antiy.demo.thread.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author ygh
 * @Description 一个同步方法可以调用另外一个同步方法, 一个对象已经拥有某个对象得锁，再次申请依然可以得到该对象的锁
 * 即synchronized是可重入的
 * @Date 2020/9/15
 */
public class SyncReen {
    private synchronized void m1() {
        System.out.println(Thread.currentThread().getName());
        m2();
    }

    private synchronized void m2() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        SyncReen syncReen = new SyncReen();
        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 60, TimeUnit.MILLISECONDS, null);


        executorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        });

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    syncReen.m1();
                }
            }).start();
        }

    }
}
