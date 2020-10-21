package com.antiy.demo.thread.valatile;

/**
 * @Author ygh
 * @Description 测试
 * @Date 2020/9/14
 */
public class Demo1 {
    public static void main(String[] args) {
        A a = new A();
        a.start();

        for (; ; ) {
            if (a.isFlag()) {
                System.out.println("有点东西");
            }
        }
    }

    static class A extends Thread {
        private boolean flag = false;

        public boolean isFlag() {
            return flag;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("flag" + flag);
        }
    }
}
