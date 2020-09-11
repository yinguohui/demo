package com.antiy.demo.jvm.clazz;

/**
 * @Author ygh
 * @Description 类加载顺序父类加载器
 * @Date 2020/9/11
 */
public class ClazzLoadSortFather {
    static {
        System.out.println("这是父类静态代码块");
    }

    public ClazzLoadSortFather(){
        System.out.println("这是父类构造函数");
    }

    {
        System.out.println("这是父类普通代码块");
    }
}
