package com.antiy.demo.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ygh
 * @Description
 *
 * -Xss128k（设置栈容量）
 * @Date 2020/9/30
 */
public class Test {
    public static void main(String[] args) {
        metaOOM();
    }

    public static void stackOOM(){
        stackOOM();
    }
    public static void heapOOM(){
        List list = new ArrayList();
        while (true){
            byte[] b = new byte[1024];
            list.add(b);
        }
    }

    public static void metaOOM(){
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            System.out.println(i);
            list.add(String.valueOf(i++).intern());
        }
    }
}
