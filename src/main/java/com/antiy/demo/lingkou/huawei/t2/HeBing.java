package com.antiy.demo.lingkou.huawei.t2;

import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/10
 */
public class HeBing {

    /**
     * 功能描述 :
     * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出
     * 4        输出 0 3
     * 0 1          1 2
     * 0 2          3 4
     * 1 2
     * 3 4
     *
     * @author ygh
     * @date 10:26
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = Integer.parseInt(scanner.nextLine());
            int[][] re = new int[x][1];
            for (int i = 0; i < x; i++) {
                String a = scanner.nextLine();
                String[] m = a.split(" ");
                int c = Integer.parseInt(m[0]);
                if (m.length > 1) {
                    re[c][0] = re[c][0] + Integer.parseInt(m[1]);
                }

            }

            for (int i = 0; i < x; i++) {
                if (re[i][0] != 0) {
                    System.out.println(i + " " + re[i][0]);
                }

            }
        }
    }
}
