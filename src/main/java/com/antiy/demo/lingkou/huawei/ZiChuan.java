package com.antiy.demo.lingkou.huawei;

import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/2
 */
public class ZiChuan {

    /**
     * 功能描述 :给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
     *
     * 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
     * @author ygh
     * @date 14:34
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            String c = "";
            if (a.length()>b.length()){
                c = b;
            }else {
                c = a;
            }
            for (int i = 0; i < c.length(); i++) {

            }
        }
    }
}
