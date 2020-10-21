package com.antiy.demo.string;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author ygh
 * @Description
 * @Date 2020/1/9
 */
public class TsubString {
    public static void main(String[] args) {
        List list = new LinkedList();
        String a = "aaa";
        String b = a.substring(0, 2);
        while (true) {
            list.add(a.substring(0, 2));
        }
    }
}
