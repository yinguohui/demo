package com.antiy.demo.lingkou.huawei;

import java.io.*;
import java.util.*;

/**
 * @Author ygh
 * @Description
 * @Date 2020/11/30
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();//next()是遇到空格；nextLine()是遇到回车
            StringBuilder sb = new StringBuilder(str);
            System.out.println(sb.reverse().toString());
//            change(str);
        }



//        String s = Integer.toBinaryString(7);
//        System.out.println(s);
//
//        int a = 100;
//        for (int i = 31; i >= 0 ; i--) {
//            System.out.print(a >>> i & 1);
//
//        }
//
//        System.out.println(test3(1516000));
//
//        test4("1516000");
//
//        System.out.println(test5(9));
//        System.out.println(test6(9));
//        test7("3+2*{1+2*[-4/(8-6)+7]}");

    }

    /**
     * 功能描述 :写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
     *
     * @author ygh
     * @date 13:43
     */

    public static long test1() {

        return Math.round(50.4);
    }


    /**
     * 功能描述 : 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数
     *
     * @author ygh
     * @date 13:48
     */

    public static int test2() {
        int a = 10;

        return a;

    }

//    private static String get(int a, String b) {
//        if (a == 0||a==1){
//            return a+"";
//        }else {
//            b = a % 2 + "";
//            a = a / 2;
//            get(a,b);
//        }
//    }

    /**
     * 功能描述 : 输入一个整数，将这个整数以字符串的形式逆序输出
     * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
     *
     * @author ygh
     * @date 14:12
     */

    public static String test3(int a) {
        String re = "";
        String var = String.valueOf(a);
        for (int i = var.length() - 1; i >= 0; i--) {
            re += var.charAt(i);
        }
        return re;
    }


    /**
     * 功能描述 : 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
     *
     * @author ygh
     * @date 15:03
     */
    public static void test4(String a) {
        String var = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            var += a.charAt(i);
        }
        System.out.println(var);
    }


    /**
     * 功能描述 : 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？
     * ”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
     * 然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
     *
     * @author ygh
     * @date 15:08
     */
    public static int test5(int n) {
        if (n == 2) {
            return 1;
        } else if (n < 2) {
            return 0;
        } else {
            return test5(n / 3 + n % 3) + n / 3;
        }
    }


    /**
     * 功能描述 :有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
     *
     * @author ygh
     * @date 15:21
     */
    public static int test6(int n) {
        if (n == 2 || n == 1) {
            return 1;
        } else {
            return test6(n - 1) + test6(n - 2);
        }
    }


    /**
     * 功能描述 : 输入一个表达式（用字符串表示），求这个表达式的值。
     * 保证字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。且表达式一定合法。
     *
     * @author ygh
     * @date 15:39
     */
    public static void test7(String var) {
        Stack stack = new Stack();
        Stack va = new Stack();
        for (int i = 0; i < var.length(); i++) {
            if ('9' > var.charAt(i) && '0' < var.charAt(i)) {
                if ((i - 2 > 0 && var.charAt(i - 1) == '-' && '9' > var.charAt(i - 2) && '0' < var.charAt(i - 2)) ||
                        ((i - 1 == 0) && var.charAt(i - 1) == '-')) {
                    stack.push(Integer.parseInt("-" + var.charAt(i)));
                } else {
                    stack.push(Integer.parseInt(String.valueOf(var.charAt(i))));
                }
            } else {
                if (i + 1 <= var.length() && i - 1 >= 0 && var.charAt(i) == '-' && var.charAt(i - 1) > '0' && var.charAt(i - 1) < 9) {

                } else {
                    va.push(var.charAt(i));
                }

            }
        }

        System.out.println("符号" + va.toString());
        System.out.println("数字" + stack.toString());
    }


    /**
     * 功能描述 :
     * 1
     *
     * 1  1  1
     *
     * 1  2  3  2  1
     *
     * 1  3  6  7  6  3  1
     *
     * 1  4  10 16 19  16 10  4  1
     *
     * 以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数，左上角数到右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
     *
     * 求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3。
     *
     *
     * 输入n(n <= 1000000000)
     * 本题有多组输入数据，输入到文件末尾，请使用while(cin>>)等方式读入
     * @author ygh
     * @date 16:54
     */


    /**
     * 功能描述 : 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数
     *
     * @author ygh
     * @date 9:46
     */

    public static void test12(int A, int B) {

        if (A < B) {
            int temp = A;
            A = B;
            B = temp;
        }
        int j = A * B;
        while (B != 0) {
            int t = A % B;
            A = B;
            B = t;
        }
        int re = j / A;
        System.out.println(re);
    }


    /**
     * 功能描述 : 将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。
     * @author ygh
     * @date 11:22
     */

    public static String change(String input){
        StringBuilder builder = new StringBuilder();
        for (int i = input.length()-1; i >=0; i--) {
            builder.append(input.charAt(i));
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

}
