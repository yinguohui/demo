package com.antiy.demo.designs.single.t3;

/**
 * @Author ygh
 * @Description 饿汉式，线程安全
 * @Date 2019/11/27
 */
public class Single {
    private static Single instance = new Single();

    /**
     * 功能描述 :构造函数私有化 类就不会被实例化
     * 是否 Lazy 初始化：否
     * 是否多线程安全：是
     * 优点：没有加锁，执行效率会提高。
     * 缺点：类加载时就初始化，浪费内存。
     * 它基于 classloder 机制避免了多线程的同步问题，不过，instance 在类装载时就实例化，虽然导致类装载的原因有很多种，
     * 在单例模式中大多数都是调用 getSingleTon 方法， 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化
     * instance 显然没有达到 lazy loading 的效果
     */
    private Single(){
    }
    private static synchronized Single getSingleTon(){
        return instance;
    }
}
