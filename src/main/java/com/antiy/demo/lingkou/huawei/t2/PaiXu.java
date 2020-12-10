package com.antiy.demo.lingkou.huawei.t2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/10
 */
public class PaiXu {


    /**
     * 功能描述 :
     * 给定n个字符串，请对n个字符串按照字典序排列。
     * 数据输出n行，输出结果为按照字典序排列的字符串。
     * @author ygh
     * @date 13:16
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = Integer.parseInt(scanner.nextLine());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(scanner.nextLine());
            }
            t1(list);
        }
    }

    public static void t1(List<String> a){
        Collections.sort(a);
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }
}
