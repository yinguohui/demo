package com.antiy.demo.string;

/**
 * @Author ygh
 * @Description + concat ,append 效率分析
 * @Date 2019/11/20
 */

public class StringCompose {
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        String a = "a";
        for (int i = 0; i < 1000000; i++) {
            a += "a";
        }
        long end1 = System.currentTimeMillis();
        System.out.println("+的效率" + (end1 - start1));

        long start2 = System.currentTimeMillis();
        String b = "a";
        for (int i = 0; i < 1000000; i++) {
            b = b.concat("a");
        }
        long end2 = System.currentTimeMillis();
        System.out.println("concat的效率" + (end2 - start2));

        long start3 = System.currentTimeMillis();
        StringBuilder c = new StringBuilder("c");
        for (int i = 0; i < 1000000; i++) {
            c = c.append("c");
        }
        long end3 = System.currentTimeMillis();
        System.out.println("append的效率" + (end3 - start3));


    }
}
