package com.antiy.demo.thread.example.print;

import com.antiy.demo.designs.zhongjie.t1.C;

/**
 * @Author ygh
 * @Description 三个线程轮流打印ABC十次
 * @Date 2020/9/23
 */
public class TPrint {
    private static Object a = new Object();
    static class A extends Thread{
        private String name;
        private Object pre;
        private Object self;

        public A(String name, Object pre, Object self) {
            this.name = name;
            this.pre = pre;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 10;
            // 多线程并发，不能用if，必须使用while循环
            while (count>0){
                // 先获取 prev 锁
                synchronized (pre){
                    // 再获取 self 锁
                    synchronized (self){
                        System.out.println(name+count);
                        // 唤醒其他线程竞争self锁，注意此时self锁并未立即释放。
                        self.notifyAll();
                        count--;
                    }
                    try {
                        // 立即释放 prev锁，当前线程休眠，等待唤醒
                        pre.wait();
                        /**
                         * JVM会在wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行。
                         */
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object t1 = new Object();
        Object t2 = new Object();
        Object t3 = new Object();
        A a =new A("A",t3,t1);
        A b =new A("B",t1,t2);
        A c =new A("C",t2,t3);

        a.start();
        Thread.sleep(10);
        b.start();
        Thread.sleep(10);
        c.start();

    }
}
