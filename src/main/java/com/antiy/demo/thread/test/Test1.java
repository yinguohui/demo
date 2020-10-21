package com.antiy.demo.thread.test;

/**
 * @Author ygh
 * <p>
 * 现有T1、T2、T3三个线程，使它们依次执行，T2在T1执行完之后执行，T3在T2执行之后执行：
 * <p>
 * join的使用
 * @Date 2020/8/18
 */
public class Test1 {

    static class A implements Runnable {
        private String name;

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    static class B extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        A a = new A();
        Thread T1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我是1 我先执行");
            }
        });
        Thread T2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    T1.join(2000);
                    System.out.println("我是2 我在一后执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        Thread T3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    T2.join();
                    System.out.println("我是3 我在二后执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        T1.start();
        T3.start();
        T2.start();
    }
}
