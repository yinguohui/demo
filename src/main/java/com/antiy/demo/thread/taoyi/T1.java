package com.antiy.demo.thread.taoyi;

/**
 * @Author ygh
 * @Description 逃逸是指在方法之内创建的对象，除了在方法体之内被引用之外，还在方法体之外被其他变量引用。
 * 也就是，在方法体之外引用方法内的对象。在方法执行完毕之后，方法中创建的对象应该被 GC 回收，但由于该对象被其他变量引用，导致 GC 无法回收
 * @Date 2020/1/7
 */
public class T1 {

    public static void test1(){
        // 逃逸对象 a
        String a = "11";
        System.out.println(a+"11");
        b(a);
    }

    public static void b(String a){
        System.out.println(a);
    }

    public static void main(String[] args) {
        test1();
    }
}

