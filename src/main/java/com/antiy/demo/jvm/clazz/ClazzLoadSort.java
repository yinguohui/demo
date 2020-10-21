package com.antiy.demo.jvm.clazz;

/**
 * @Author ygh
 * @Description 类加载顺序
 * <p>
 * 在初始化阶段对类进行加载
 * 首先调用cinit方法初始化静态方法和对静态方法赋值--在子类加载前先调用父类得cinit方法
 * 然后init 成员变量和成员对象的赋值，普通语句块的执行，构造函数的执行
 * @Date 2020/9/11
 */
public class ClazzLoadSort extends ClazzLoadSortFather {
//    static {
//        System.out.println("这是子类静态代码块");
//    }

    public ClazzLoadSort() {
        System.out.println("这是子类构造函数");
    }

//    {
//        System.out.println("这是子类普通代码块");
//    }

    public static void main(String[] args) {
        Object a = new Object();
        ClazzLoadSort sort = new ClazzLoadSort();
        Thread thread = Thread.currentThread();
//        thread.setContextClassLoader();
    }
}
