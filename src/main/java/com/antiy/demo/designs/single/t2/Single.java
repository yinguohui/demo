package com.antiy.demo.designs.single.t2;

/**
 * @Author ygh
 * @Description 懒汉式，线程安全
 * @Date 2019/11/27
 */
public class Single {
    private static Single instance;

    /**
     * 功能描述 :构造函数私有化 类就不会被实例化
     * 是否 Lazy 初始化：是
     * 是否多线程安全：是
     * <p>
     * 优点：第一次调用才初始化，避免内存浪费。
     * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
     * getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）
     */
    private Single() {
    }

    private static synchronized Single getSingleTon() {
        if (instance == null) {
            return new Single();
        }
        return instance;
    }
}
