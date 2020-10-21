package com.antiy.demo.jdbc.druid;

/**
 * introductions:内部类单例模式来对外提供连接池对象
 * 严格保证线程安全机制
 * 注意：
 * 简单的单例模式还不能完全防御内存当中在运行时期有多个对象
 * 只是在返回时合并为一个结果
 * 会给系统带来额外开销
 * created by Heylink on 2018/4/27 18:32
 */
public class PoolManager {

    /**
     * 内部类
     *
     * @param
     * @author heylinlook
     * @date 2018/4/27 20:44
     * @return
     */
    private static class createPool {
        private static SimplePoolImpl simplePool = new SimplePoolImpl();
    }

    /**
     * JVM中类加载器字节码是一个严格互斥理论模型
     * 类加载器原理
     * 完美的实现线程安全
     *
     * @param
     * @return
     * @author heylinlook
     * @date 2018/4/27 20:45
     */
    public static SimplePoolImpl getInstance() {
        return createPool.simplePool;
    }
}
