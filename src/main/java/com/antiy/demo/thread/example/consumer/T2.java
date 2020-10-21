package com.antiy.demo.thread.example.consumer;

/**
 * @Author ygh
 * @Description
 * @Date 2020/10/12
 */
public class T2 {
    private static Integer Num = 10;
    private static Object object1 =new Object();
    private static Object object2 = new Object();

    static class A implements Runnable {
        @Override
        public void run() {
            synchronized (Num.getClass()) {
                while (true) {
                    Num++;
                    try {
                        object1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("生产了一个");

                    object2.notifyAll();
                }
            }

        }
    }

    static class B implements Runnable {

        @Override
        public void run() {
            synchronized (Num.getClass()) {
                while (true) {
                    Num--;
                    try {
                        object2.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("消费了一个");
                    object1.notifyAll();
                }


            }

        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        Runnable target;
        Thread c = new Thread(a);
        Thread d = new Thread(b);
        c.start();
        d.start();
    }

}
