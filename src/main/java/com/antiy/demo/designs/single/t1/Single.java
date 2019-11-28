package com.antiy.demo.designs.single.t1;

/**
 * @Author ygh
 * @Description 懒汉式，线程不安全
 * @Date 2019/11/27
 */
public class Single {
    private static Single instance;

    /**
     * 功能描述 :构造函数私有化 类就不会被实例化
     * 是否 Lazy 初始化：是
     * 是否多线程安全：否
     */
    private Single(){
    }
    private static Single getSingleTon(){
        if (instance==null){
            return new Single();
        }
        return instance;
    }
}
