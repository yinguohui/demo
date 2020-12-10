package com.antiy.demo.lingkou.huawei.t2;

import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/9
 */
public class ZhiYinShu {

    /**
     * 功能描述 :功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
     * <p>
     * 最后一个数后面也要有空格 待优化
     *
     * @author ygh
     * @date 16:06
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int temp = 2;
            StringBuilder s = new StringBuilder();
            while (x > 3) {
                if (x % temp == 0){
                    x = x/temp;
                    s.append(temp+" ");
                }else {
                   temp = getRe(temp+1,x);
                }
            }
            if (x<=3&&x>1){
                s.append(x+" ");
            }
            System.out.println(s.toString());
        }

    }

    public static int getRe(int x, int y) {
        int re = x;
        for (int i = x; i <= y; i++) {
            if (judge(i)) {
                re = i;
                break;
            }
        }
        return re;
    }

    public static boolean judge(int x) {
        for (int i = 2; i <= x / 2; i++) {
            if (x % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}
