package com.antiy.demo.lingkou.huawei.t2;

import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/10
 */
public class ZoFuChuanPaiXu {


    /**
     * 功能描述 :
     * 编写一个程序，将输入字符串中的字符按如下规则排序。
     * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
     * 如，输入： Type 输出： epTy
     * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
     * 如，输入： BabA 输出： aABb
     * 规则 3 ：非英文字母的其它字符保持原来的位置。
     * 如，输入： By?e 输出： Be?y
     *
     * @author ygh
     * @date 13:56
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }

    public static void paixu(String a) {
        char[] m = a.toCharArray();
        char[] k = new char[a.length()];
        int z = 0;
        for (int i = 0; i < m.length; i++) {
            if ((m[i] >= 'a' && m[i] <= 'z') || (m[i] >= 'A' && m[i] <= 'Z')) {
                k[z] = m[i];
                z++;
            }
        }
        for (int i = 0; i < z-1; i++) {
            for (int j = i + 1; j < z; j++) {
//                if (k[i]>k[j]||())
            }
        }
    }
}
