package com.antiy.demo.java8.fanxing;

/**
 * @Author ygh
 * @Description 泛型加法
 * @Date 2020/11/23
 */
public class GenericAdd {

    private static  <T> T add(T a,T b){
        System.out.println("测试"+a+b);
        return a;
    }

    public static void main(String[] args) {
        GenericAdd.add(1111,"b");
    }
}
