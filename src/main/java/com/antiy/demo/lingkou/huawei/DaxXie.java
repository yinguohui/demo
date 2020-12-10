package com.antiy.demo.lingkou.huawei;

import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/2
 */
public class DaxXie {

    /**
     * 功能描述 :找出给定字符串中大写字符(即'A'-'Z')的个数。
     * @author ygh
     * @date 13:13
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int s = 0;
            String a = scanner.nextLine();
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i)>='A'&&a.charAt(i)<='Z'){
                    s++;
                }
            }
            System.out.println(s);
        }
    }
}
