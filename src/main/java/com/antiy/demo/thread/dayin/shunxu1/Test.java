package com.antiy.demo.thread.dayin.shunxu1;


/**
 * @Author ygh
 * @Description 交替打印A1 A2 A3
 * @Date 2020/1/8
 */
public class Test {
    private static Object a = new Object();
    private static Object b = new Object();
    private static Object c = new Object();
    public static void main(String[] args) {
        //ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,0L, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(10));
    }

    static class ThreadA extends Thread {
        private String name;

        public ThreadA(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    sleep(1000);
                    System.out.println(name);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
