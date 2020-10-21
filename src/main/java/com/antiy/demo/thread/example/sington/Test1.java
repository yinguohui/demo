package com.antiy.demo.thread.example.sington;

/**
 * @Author ygh
 * @Description 单例模式双检测
 *
 * 利用JVM的类加载和静态变量初始化特征来创建Singleton实例，或者是利用枚举类型来创建Singleton --- 创建线程安全的单例
 * @Date 2020/10/15
 */
public class Test1 {

    public static void main(String[] args) {
        String a = "adada\"dadada";
        String b = a.replaceAll("\"","");
        System.out.println(b);
        System.out.println(a);
    }
}
