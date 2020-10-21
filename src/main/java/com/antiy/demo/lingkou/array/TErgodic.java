package com.antiy.demo.lingkou.array;

/**
 * @Author ygh
 * @Description 数组遍历
 * @Date 2020/9/24
 */
public class TErgodic {

    public static void t1() {
        //正向遍历
        int m = 1;
        int n = 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

            }
            // 计算 dp[i][j]
        }
    }

    public static void t2() {
        //有时候我们反向遍历
        int m = 1;
        int n = 1;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 计算 dp[i][j]
            }
        }


    }

    public static void t3() {
        //斜向遍历
        int m = 1;
        int n = 1;
        int[][] dp = new int[m][n];
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = l + i - 1;
                // 计算 dp[i][j]
            }
        }
    }
}
