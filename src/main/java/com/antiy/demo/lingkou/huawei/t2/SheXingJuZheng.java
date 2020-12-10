package com.antiy.demo.lingkou.huawei.t2;

import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/10
 */
public class SheXingJuZheng {


    /**
     * 功能描述 :
     * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
     * <p>
     * 例如，当输入5时，应该输出的三角形为：
     * <p>
     * 1 3 6 10 15
     * <p>
     * 2 5 9 14
     * <p>
     * 4 8 13
     * <p>
     * 7 12
     * <p>
     * 11
     *
     * @author ygh
     * @date 14:31
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            int q = 1;

            for (int i = 1; i <= n; i++) {
                System.out.print(q);
                System.out.print(" ");
                int k = q;
                for (int j = i+1; j <= n ; j++) {
                    k = k + j ;
                    System.out.print(k);
                    System.out.print(" ");
                }
                q = q + i;
                System.out.println();
            }
        }
    }
}
