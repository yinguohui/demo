package com.antiy.demo.lingkou.dynicplan;

/**
 * @Author ygh
 * @Description 凑硬币问题
 * 给定硬币[k1,k2,k3.....] 然后给定整数n ，找出凑够n所需硬币得最小数
 * 例 [1,2,5] n=11
 * 输出 3
 * @Date 2020/9/24
 */
public class TCoinSolution {
    static int sum = 11;

    public static void main(String[] args) {
        int[]a = {1,2,5};
        answer1(a,11,0);
        System.out.println(sum);
    }


    public static void answer1(int[] a, int m, int n) {
        for (int i = 0; i < a.length; i++) {
            if (m - a[i] == 0) {
                ++n;
                if (sum > n) {
                    sum = n;
                }

            }
            if (m - a[i] > 0) {
                answer1(a, m - a[i], n + 1);
            }
        }
    }
}
