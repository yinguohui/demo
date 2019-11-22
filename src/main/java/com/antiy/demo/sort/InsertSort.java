package com.antiy.demo.sort;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/21
 */
public class InsertSort {

    /**
     * 功能描述 : 插入排序
     * @author ygh
     * @date 15:54
     */
    public static int[] insertSort(int[] unSortedList){
        for (int i = 0; i < unSortedList.length; i++) {
            for (int j = 0; j < unSortedList.length; j++) {
                if (unSortedList[i]<unSortedList[j]){
                    // 交换
                    int temp = unSortedList[j];
                    unSortedList[j] = unSortedList[i];
                    unSortedList[i] = temp;
                }
            }
        }
        return unSortedList;
    }

    public static void main(String[] args) {
        int[] test = {1,8,5,6,4,9,7,2,3};
        test = bubbleSortFunction(test);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + " ");
        }
    }
    
    
    /**
     * 功能描述 : 插入排序
     * @author ygh
     * @date 16:27
     */
    
    private static int[] insertSortFunction(int[] unSortedList){
        for (int i = 1; i < unSortedList.length; i++) {
            for (int j = i; j > 0; j--) {
                if (unSortedList[i]<unSortedList[j]){
                    // 交换
                    int temp = unSortedList[i];
                    unSortedList[i] = unSortedList[j];
                    unSortedList[j] = temp;
                }
            }
        }
        return unSortedList;
    }


    /**
     * 功能描述 : 冒泡排序
     *  平均时间复杂度	最好情况	最坏情况	空间复杂度
     *  O(n²)	        O(n)	O(n²)	O(1)
     *  比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     *  对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     *  针对所有的元素重复以上的步骤，除了最后一个。
     *  持续每次对越来越少的元素重复上面的步骤①~③，直到没有任何一对数字需要比较。
     * @author ygh
     * @date 16:48
     */

    private static int[] bubbleSortFunction(int[] unSortedList){
        for (int i = 0; i < unSortedList.length-1; i++) {
            for (int j = 1; j < unSortedList.length-1; j++) {
                if (unSortedList[j]>unSortedList[j+1]){
                    // 交换
                    int temp = unSortedList[j+1];
                    unSortedList[j+1] = unSortedList[j];
                    unSortedList[j] = temp;
                }
            }
        }
        return unSortedList;
    }
}
