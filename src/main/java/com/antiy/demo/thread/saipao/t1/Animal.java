package com.antiy.demo.thread.saipao.t1;

/**
 * @Author ygh
 * @Description
 * @Date 2020/1/9
 */
public abstract class Animal extends Thread{
    public double length = 20;

    @Override
    public void run() {
        super.run();
        while (length>0){
            running();
        }
    }

    // 子类各自动物需要实现的
    public abstract void running();

    //跑完时的回调接口，通知其他不跑了

    //在需要回调数据的地方（两个子类需要），声明一个接口
    public static interface Calltoback{
        public void win();
    }

    //2.创建接口对象
    public Calltoback calltoback;

}
