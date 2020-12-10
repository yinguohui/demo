package com.antiy.demo.lingkou.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/2
 */
public class ErWei {

    /**
     * 功能描述 :
     * 有一个大小的数据表，你会依次进行以下5种操作：
     * 1.输入和，初始化大小的表格。
     * 2.输入x_1x1、y_1y1、x_2x 2、y_2y2，交换坐标在(x_1,y_1)(x1,y1)和(x_2,y_2)(x2,y2)的两个数。
     * 3.输入，在第行左边添加一行。
     * 4.输入，在第列上方添加一列。
     * 5.输入、，查找坐标为的单元格的值。
     * 请编写程序，判断对表格的各种操作是否合法。
     * <p>
     * 详细要求:
     * <p>
     * 1.数据表的最大规格为9行*9列，对表格进行操作时遇到超出规格应该返回错误。
     * 2.对于插入操作，如果插入后行数或列数超过9了则应返回错误。如果插入成功了则将数据表恢复至初始化的大小，多出的数据则应舍弃。
     * 3.所有输入坐标操作，对大小的表格，行号坐标只允许0~m-1，列号坐标只允许0~n-1。超出范围应该返回错误。
     * <p>
     * 本题含有多组样例输入！
     *
     * @author ygh
     * @date 9:44
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = null;
        while ((string = bufferedReader.readLine()) != null) {
            String[] mn = string.split(" ");
            int m = Integer.parseInt(mn[0]);
            int n = Integer.parseInt(mn[1]);
            if (m <= 9 && m > 0 && n <= 9 && n > 0) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            string = bufferedReader.readLine();
            String[] zb = string.split(" ");
            int x1 = Integer.parseInt(zb[0]);
            int y1 = Integer.parseInt(zb[1]);
            int x2 = Integer.parseInt(zb[2]);
            int y2 = Integer.parseInt(zb[3]);
            if (0 <= x1 && 0 <= y1 && 0 <= x2 && 0 <= y2 && x1 < m && x2 < m && y1 < n && y2 < n) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            int c = Integer.valueOf(bufferedReader.readLine());
            if (c >= 0 && c < m && (m + 1 <= 9)) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            int c1 = Integer.valueOf(bufferedReader.readLine());
            if (c1 >= 0 && c1 < n && (n + 1 <= 9)) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            string = bufferedReader.readLine();
            mn = string.split(" ");
            int d1 = Integer.parseInt(mn[0]);
            int d2 = Integer.parseInt(mn[1]);
            if (0 <= d1 && d1 < m && 0 <= d2 && d2 < n) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
        }
    }
}
