package com.antiy.demo.designs.single.t1;

import java.util.HashSet;
import java.util.Set;

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

    public static void main(String[] args) {
        Set s  = new HashSet();
        s.add(null);
        System.out.println(s.size());
        int[] a = new int[10];
        int m = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (i+4>a.length){
//                if (a[i+3])
            }
        }
    }


}
