package com.antiy.demo.lingkou;

/**
 * @Author ygh
 * @Description 给一组整数，按照升序排序，使用选择排序，冒泡排序，插入排序或者任何 O(n2) 的排序算法
 * @Date 2020/1/10
 */
public class Test1 {


    /**
     * 功能描述 :
     * 样例  1:
     * 输入:  [3, 2, 1, 4, 5]
     * 输出:  [1, 2, 3, 4, 5]
     *
     * @author ygh
     * @date 14:23
     */
    public static void main(String[] args) {
        int[] a = {3, 2, 1, 4, 5};
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
