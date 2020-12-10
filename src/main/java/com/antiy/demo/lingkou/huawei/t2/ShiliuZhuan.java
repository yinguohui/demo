package com.antiy.demo.lingkou.huawei.t2;

import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/2
 */
public class ShiliuZhuan {

    /**
     * 功能描述 :写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
     *
     * @author ygh
     * @date 16:17
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            int sum = 0;
            for (int i = a.length() - 1; i >= 2; i--) {
                if (a.charAt(i) == 'A') {
                    sum += get(a.length() - i-1, 10);
                } else if (a.charAt(i) == 'B') {
                    sum += get(a.length() - i-1, 11);
                } else if (a.charAt(i) == 'C') {
                    sum += get(a.length() - i-1, 12);
                } else if (a.charAt(i) == 'D') {
                    sum += get(a.length() - i-1, 13);
                } else if (a.charAt(i) == 'E') {
                    sum += get(a.length() - i-1, 14);
                } else if (a.charAt(i) == 'F') {
                    sum += get(a.length() - i-1, 15);
                } else {
                    sum += get(a.length() - 1 - i, Integer.parseInt(String.valueOf(a.charAt(i))));
                }

            }

            System.out.println(sum);
        }
    }

    public static int get(int n, int x) {
        if (n == 0) {
            return x;
        }
        for (int i = 0; i < n; i++) {
            x = x * 16;
        }

        return x;
    }
}
