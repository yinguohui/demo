package com.antiy.demo.thread.test;

import java.util.Collections;
import java.util.concurrent.*;

/**
 * @Author ygh
 * @Description 1.编写10个线程，第一个线程从1加到10，第二个线程从11加20…第十个线程从91加到100，最后再把10个线程结果相加
 * @Date 2020/8/18
 */
public class    Test2 {
    static class A implements Callable<Integer> {
        private int base;

        public A(int base) {
            this.base = base;
        }

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = base; i < (base + 10); i++) {
                sum += i;
            }
            return sum;
        }
    }

    static class B implements Runnable {
        private int base;
        private int count;

        public B(int base) {
            this.base = base;
        }

        @Override
        public void run() {
            int sum = 0;
            for (int i = base; i < (base + 10); i++) {
                sum += i;
            }
            System.out.println("aaaaaaa" + sum);
            this.setCount(sum);
        }

        public void setBase(int base) {
            this.base = base;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int a = 0;
        for (int i = 0; i < 10; i++) {
            A b = new A(i * 10);
            FutureTask<Integer> future = new FutureTask(b);
            new Thread(future).start();
            a = a + future.get();
        }
        CopyOnWriteArrayList arrayList = new CopyOnWriteArrayList();
        Collections.synchronizedList(arrayList);
        System.out.println("zzzzzzzz" + a);
        int cc = 0;
        for (int i = 0; i < 99; i++) {
            cc += i;

        }
    }

}
