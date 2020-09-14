package com.antiy.demo.thread.example.consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author ygh
 * @Description
 * @Date 2020/8/25
 */
public class T1 {
    private static volatile int a = 100;

    public static int getA() {
        return a;
    }

    public static void setA(int a) {
        T1.a = a;
    }

    private static Object consumer = new Object();
    private static Object produce = new Object();
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static Condition condition1 = lock.newCondition();

    static class A implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (getA() == 0) {
                    try {
                        consumer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                a--;
                System.out.println(Thread.currentThread().getName() + "消费了一个,还剩余" + getA());
                produce.notify();
            }
        }
    }

    static class B implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (getA() == 100) {
                    try {
                        produce.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                a++;
                System.out.println(Thread.currentThread().getName() + "生产了一个,还剩余" + getA());
                consumer.notify();
            }
        }
    }


    public static void main(String[] args) {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        if (getA() == 0) {
                            condition.await();
                        }
                        T1.a--;
                        System.out.println(Thread.currentThread().getName() + "消费了一个,还剩余" + getA());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                        condition1.signal();
                    }
                }

            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (T1.class) {
                    while (true) {
                        lock.lock();
                        try {
                            if (getA() == 100) {
                                condition1.await();
                            }
                            T1.a++;
                            System.out.println(Thread.currentThread().getName() + "生产了一个,还剩余" + getA());

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            lock.unlock();
                            condition.signal();
                        }


                    }
                }


            }
        });
        a.start();
        b.start();
    }
}
