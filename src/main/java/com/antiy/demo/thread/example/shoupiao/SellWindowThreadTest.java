package com.antiy.demo.thread.example.shoupiao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author ygh
 * @Description 售票窗口线程
 * @Date 2020/1/7
 */
public class SellWindowThreadTest {
    public static int count = 2000;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        executorService.execute(new SellWindowThread());
//        executorService.execute(new SellWindowThread());
//        executorService.execute(new SellWindowThread());
        new SellWindowThread("a").start();
        new SellWindowThread("b").start();
        new SellWindowThread("c").start();
    }

    static class SellWindowThread extends Thread {
        private String name;

        public SellWindowThread(String name) {
            this.name = name;
        }

        public static Object o = "";

        @Override
        public void run() {
            while (count > 0) {
                synchronized (o.getClass()) {
                    System.out.println("当前线程：" + name + "卖了一张票");
                    System.out.println("余下" + (count--) + "张");
                }
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }
}
