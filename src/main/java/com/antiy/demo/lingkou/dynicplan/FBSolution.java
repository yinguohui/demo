package com.antiy.demo.lingkou.dynicplan;

import org.springframework.util.StopWatch;

/**
 * @Author ygh
 * @Description 斐波拉契数列
 * <p>
 * int fib(int N) {
 * if (N == 1 || N == 2) return 1;
 * return fib(N - 1) + fib(N - 2);
 * }
 * @Date 2020/9/16
 */
public class FBSolution {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
//        System.out.println(answer1(40));
//        int n = 40;
//        int [] a =new int[n+1];
//        System.out.println(answer2(n,a));
//        System.out.println(answer3(40));
        System.out.println(answer4(40));
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }

    public static int answer1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return answer1(n - 1) + answer1(n - 2);
        }
    }

    public static int answer2(int n, int[] a) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (a[n] != 0) {
            return a[n];
        }else {
            a[n] = answer2(n-1,a)+answer2(n-2,a);
            return a[n];
        }
    }

    public static int answer3(int n) {
        int []a = new int[n+1];
        a[1] = a[2] = 1;
        for (int i = 3; i <= n; i++) {
            a[i] = a[i-1] +a[i-2];
        }
        return a[n];

    }
    public static int answer4(int n) {
        int pre = 1;
        int cur = 1;
        for (int i = 3; i <= n; i++) {
            int sum = pre +cur;
            cur = pre;
            pre = sum;
        }
        return pre;

    }
}
