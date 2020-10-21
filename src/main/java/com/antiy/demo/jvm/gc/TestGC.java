package com.antiy.demo.jvm.gc;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

/**
 * @Author ygh
 * @Description
 *
 * 在 Java 中，可作为 GC Roots 的对象包括：
 *  虚拟机栈中引用的对象
 *  方法区中类静态属性引用的对象
 *  方法区中常量引用的对象
 *  本地方法栈中 JNI（一般说的 Native 方法）引用的对象
 * @Date 2020/9/30
 */
public class TestGC {
    public Object instance = null;

    private final int _1MB = 1024*1024;

    private byte[] bigSize = new byte[2*_1MB];

    public static void testGC(){
        TestGC a = new TestGC();
        TestGC b = new TestGC();
        a.instance = b;
        b.instance = a;

        a = null;
        b = null;

        // 这里发生GC a b会被回收吗
        System.gc();
    }

    public static void main(String[] args) {

    }

    class A implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            return null;
        }
    }
}
