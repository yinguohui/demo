package com.antiy.demo.lingkou.huawei;

import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/1
 */
public class DengCha {

    /**
     * 功能描述 :
     * 功能:等差数列 2，5，8，11，14。。。。
     *
     * 输入:正整数N >0
     *
     * 输出:求等差数列前N项和
     *
     * 本题为多组输入，请使用while(cin>>)等形式读取数据
     * @author ygh
     * @date 13:40
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            Integer s = Integer.valueOf(scanner.nextLine());
            System.out.println(s*2+(s-1)*s*3/2);
        }
    }
}
