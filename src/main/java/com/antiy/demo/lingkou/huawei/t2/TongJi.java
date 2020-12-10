package com.antiy.demo.lingkou.huawei.t2;

import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/10
 */
public class TongJi {


    /**
     * 功能描述 :   编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
     * 例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
     * @author ygh
     * @date 11:31
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(count(scanner.nextLine()));
        }
    }

    public static int count(String a){
        int[] re = new int[128];
        int n = a.length();
        int s = 0;
        for (int i = 0; i < a.length(); i++) {
            if (re[a.charAt(i)]==0){
                s++;
            }
            re[a.charAt(i)] = 1;
        }
        return s;
    }
}
