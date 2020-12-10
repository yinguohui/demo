package com.antiy.demo.lingkou.huawei.t2;

import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/9
 */
public class DianDao {

    /**
     * 功能描述 :
     * 输入一个整数，将这个整数以字符串的形式逆序输出
     * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
     *
     * @author ygh
     * @date 14:32
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            print(scanner.nextLine());
        }
    }

    public static void print(String in) {
        StringBuilder builder = new StringBuilder();
        for (int i = in.length() - 1; i >= 0; i--) {
            builder.append(in.charAt(i));
        }
        System.out.println(builder.toString());
    }
}
