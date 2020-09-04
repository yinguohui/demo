package com.antiy.demo.thread.reference;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ygh
 * @Description
 * @Date 2020/3/30
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o);
        System.out.println("垃圾回收前"+weakReference.get());
        //o = null;
        System.gc();
        Thread.sleep(1000);
        System.out.println("垃圾回收后"+weakReference.get());
        String test = "ffffasdfffff";
        String[] z = test.split("a",3);
        List list = new ArrayList();
        for (int i = 0; i < z.length; i++) {
            System.out.println(z[i]);
        }
        while (true){
            Thread.sleep(2000);
            byte []a = new byte[1024*1024*1];
            list.add(a);
            list.forEach(x-> System.out.println(x));
        }
    }
}
