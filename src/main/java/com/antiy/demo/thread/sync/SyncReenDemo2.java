package com.antiy.demo.thread.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author ygh
 * @Description 可重入测试 父类与子类
 * 子类对象初始化前，会调用父类构造方法，在结构上相当于包裹了一个父类对象，用的都是this锁对象
 * @Date 2020/9/15
 */
public class SyncReenDemo2 {
    public synchronized void m() {
        System.out.println(Thread.currentThread().getName());
    }

    static class SyncReenDemoSon extends SyncReenDemo2 {

        @Override
        public synchronized void m() {
            super.m();
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        SyncReenDemoSon syncReenDemoSon = new SyncReenDemoSon();
        ExecutorService executorService = new
                ThreadPoolExecutor(10, 10, 60, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024));
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    syncReenDemoSon.m();
                }
            });
        }
    }
}
