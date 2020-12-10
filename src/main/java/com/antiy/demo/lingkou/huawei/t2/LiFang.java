package com.antiy.demo.lingkou.huawei.t2;

import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/7
 */
public class LiFang {

    /**
     * 功能描述 :
     * 计算一个数字的立方根，不使用库函数。
     * 保留一位小数。
     *
     * @author ygh
     * @date 16:05
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(getLiFang(scanner.nextDouble()));
        }
    }

    public static double getLiFang(double x) {
        double max = x;
        double min = 0;
        double mid =  0;
        while (max - min > 0.01) {
            double s = mid * mid * mid;
            if (s > x) {
                mid = (min + mid)/2;
                max = mid;
            } else if (s < x) {
                mid = (max + mid)/2;
                min = mid;
            } else {
                return mid / 2;
            }
        }
        return max;
    }
}
