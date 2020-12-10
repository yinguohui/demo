package com.antiy.demo.lingkou.huawei;

import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/2
 */
public class NiKe {

    /**
     * 功能描述 :题目描述
     * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
     * <p>
     * 例如：
     * <p>
     * 1^3=1
     * <p>
     * 2^3=3+5
     * <p>
     * 3^3=7+9+11
     * <p>
     * 4^3=13+15+17+19
     * <p>
     * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
     * 本题含有多组输入数据。
     *
     * @author ygh
     * @date 13:18
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Integer a = scanner.nextInt();
            int s = a * a;
            String re = "";
            if (a%2==0){
                for (int i = 1; i <= a; i++) {
                    re = re +"+"+(s-1-(a/2)*2+2*i);
                }
            }
            if (a%2!=0){
                for(int i = 1; i <= a; i++) {
                    re = re +"+"+(s-(a/2)*2+2*(i-1));
                }
            }
            System.out.println(re.substring(1));
        }
    }
}
