package com.antiy.demo.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ygh
 * @Description
 * @Date 2020/9/23
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list0 = new ArrayList<>();
        long start0 = System.currentTimeMillis();
        for (int i = 0; i <= 10000001; i++) {
            list0.add(i);
        }
        System.out.println(System.currentTimeMillis() - start0);
        long start1 = System.currentTimeMillis();
        for (int i = 10000000; i > 0; i--) {
            list0.remove(i);
        }
        System.out.println(System.currentTimeMillis() - start1);
        long start2 = System.currentTimeMillis();
        for (int i = 0; i <= 10000001; i++) {
            list0.add(i);
        }
        System.out.println(System.currentTimeMillis() - start2);

        Thread.sleep(60000);
    }
}
