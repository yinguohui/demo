package com.antiy.demo.sort;

import java.util.Arrays;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/21
 */
public class InsertSort {

    /**
     * 功能描述 : 插入排序
     *
     * @author ygh
     * @date 15:54
     */
    public static int[] insertSort(int[] unSortedList) {
        for (int i = 0; i < unSortedList.length; i++) {
            for (int j = 0; j < unSortedList.length; j++) {
                if (unSortedList[i] < unSortedList[j]) {
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
        int[] test = {1, 81, 522, 655, 444, 1, 81, 522, 655, 444, 1, 81, 522, 655, 444, 1, 81, 522, 655, 444, 1, 81, 522, 655, 444,  1, 81, 522, 655, 444, 1, 81, 522, 655, 444, 1, 81, 522, 655, 444, 1, 81, 522, 655, 444, 733, 2, 3};
        radixSort(test);
        int[] test1 = {1, 81, 522, 655, 444,  1, 81, 522, 655, 444, 1, 81, 522, 655, 444, 1, 81, 522, 655, 444, 1, 81, 522, 655, 444,  1, 81, 522, 655, 444, 1, 81, 522, 655, 444, 1, 81, 522, 655, 444, 1, 81, 522, 655, 444, 733, 2, 3};
        //
        // radixMaxSort(test1);
        int[] test2 = {1, 81, 522, 655, 444,  1, 81, 522, 655, 444, 1, 81, 522, 655, 444, 1, 81, 522, 655, 444, 1, 81, 522, 655, 444,  1, 81, 522, 655, 444, 1, 81, 522, 655, 444, 1, 81, 522, 655, 444, 1, 81, 522, 655, 444, 733, 2, 3};
        long s = System.currentTimeMillis();
        insertSort(test2);
        long e = System.currentTimeMillis();
        System.out.println("=======================" + (e-s));
    }


    /**
     * 功能描述 : 插入排序
     *
     * @author ygh
     * @date 16:27
     */

    private static int[] insertSortFunction(int[] unSortedList) {
        for (int i = 1; i < unSortedList.length; i++) {
            for (int j = i; j > 0; j--) {
                if (unSortedList[i] < unSortedList[j]) {
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
     * 平均时间复杂度	最好情况	最坏情况	空间复杂度
     * O(n²)	        O(n)	O(n²)	O(1)
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤①~③，直到没有任何一对数字需要比较。
     *
     * @author ygh
     * @date 16:48
     */

    private static int[] bubbleSortFunction(int[] unSortedList) {
        for (int i = 0; i < unSortedList.length - 1; i++) {
            for (int j = 1; j < unSortedList.length - 1; j++) {
                if (unSortedList[j] > unSortedList[j + 1]) {
                    // 交换
                    int temp = unSortedList[j + 1];
                    unSortedList[j + 1] = unSortedList[j];
                    unSortedList[j] = temp;
                }
            }
        }
        return unSortedList;
    }


    /**
     * 功能描述 :简单选择排序
     * <p>
     * 1\. 从待排序序列中，找到关键字最小的元素；
     * 2\. 如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
     * 3\. 从余下的 N - 1 个元素中，找出关键字最小的元素，重复①、②步，直到排序结束。
     * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * 平均时间复杂度	最好情况	最坏情况	空间复杂度
     * O(n²)	        O(n²)	O(n²)	O(1)
     *
     * @author ygh
     * @date 10:20
     */
    private static int[] simpleSort(int[] unSortedList) {
        for (int i = 0; i < unSortedList.length - 1; i++) {
            int min = i;
            // 选出数组中最小的数的坐标
            for (int j = i + 1; j < unSortedList.length; j++) {
                if (unSortedList[min] > unSortedList[j]) {
                    min = j;
                }
            }
            // 交换
            if (min != i) {
                int temp = unSortedList[i];
                unSortedList[i] = unSortedList[min];
                unSortedList[min] = temp;
            }
        }

        return unSortedList;
    }


    /**
     * 功能描述 : 堆排序
     * 1\. 先将初始序列K[1..n]建成一个大顶堆, 那么此时第一个元素K1最大, 此堆为初始的无序区.
     * 2\. 再将关键字最大的记录K1 (即堆顶, 第一个元素)和无序区的最后一个记录 Kn 交换, 由此得到新的无序区K[1..n−1]和有序区K[n], 且满足K[1..n−1].keys⩽K[n].key
     * 3\. 交换K1 和 Kn 后, 堆顶可能违反堆性质, 因此需将K[1..n−1]调整为堆. 然后重复步骤②, 直到无序区只有一个元素时停止.
     *
     * @author ygh
     * @date 15:30
     */
    private static int[] heapSort(int[] unSortedList) {
        for (int i = unSortedList.length; i > 0; i--) {
            // 构造最大根堆
            maxHeap(unSortedList, i);
            // 交换位置
            int temp = unSortedList[0];
            unSortedList[0] = unSortedList[i - 1];
            unSortedList[i - 1] = temp;
        }
        return unSortedList;
    }


    /**
     * ①. 建立堆的过程, 从length/2 一直处理到0, 时间复杂度为O(n);
     * ②. 调整堆的过程是沿着堆的父子节点进行调整, 执行次数为堆的深度, 时间复杂度为O(lgn);
     * ③. 堆排序的过程由n次第②步完成, 时间复杂度为O(nlgn).
     * <p>
     * 平均时间复杂度	              最好情况  	            最坏情况	                空间复杂度
     * O(nlog2n)O(nlog2⁡n)       O(nlog2n)O(nlog2⁡n)	O(nlog2n)O(nlog2⁡n)	O(1)
     */
    private static int[] maxHeap(int[] unSortedList, int limit) {
        for (int parentIdx = limit / 2; parentIdx >= 0; parentIdx--) {
            if (parentIdx * 2 >= limit) {
                continue;
            }
            // 左子节点位置
            int left = parentIdx * 2;
            // 右子节点位置，如果没有右节点，默认为左节点位置
            int right = (left + 1) >= limit ? left : (left + 1);
            // 交换父节点与左右子节点中的最大值
            int maxChildId = unSortedList[left] >= unSortedList[right] ? left : right;
            if (unSortedList[maxChildId] > unSortedList[parentIdx]) {
                int temp = unSortedList[parentIdx];
                unSortedList[parentIdx] = unSortedList[maxChildId];
                unSortedList[maxChildId] = temp;
            }
        }
        System.out.println("Max_Heapify: " + Arrays.toString(unSortedList));
        return unSortedList;
    }


    /**
     * 功能描述 :
     *  快速排序（递归）
     *
     *   ①. 从数列中挑出一个元素，称为"基准"（pivot）。
     *   ②. 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
     *   ③. 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * @author ygh
     * @date 10:02
     */
    private static void quickSort(int[] unSortedList, int low, int high) {
        if (unSortedList.length <= 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;
        // 挖坑1：保存基准的值
        int temp = unSortedList[left];
        while (left < right) {
            //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
            while (left < right && unSortedList[right] >= temp) {
                right--;
            }
            unSortedList[left] = unSortedList[right];
            //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
            while (left < right && unSortedList[left] <= temp) {
                left++;
            }
            unSortedList[right] = unSortedList[left];
        }
        // 基准值填补到坑3中，准备分治递归快排
        unSortedList[left] = temp;
        System.out.println("Sorting: " + Arrays.toString(unSortedList));
        quickSort(unSortedList, low, left - 1);
        quickSort(unSortedList, left + 1, high);
    }


    /**
     * 功能描述 :
     *
     *  归并排序（递归）
     *
     *  ①. 将序列每相邻两个数字进行归并操作，形成 floor(n/2)个序列，排序后每个序列包含两个元素；
     *  ②. 将上述序列再次归并，形成 floor(n/4)个序列，每个序列包含四个元素；
     *  ③. 重复步骤②，直到所有元素排序完毕。
     *
     *  平均时间复杂度	最好情况  	最坏情况	      空间复杂度
     *  O(nlog₂n)	    O(nlog₂n)	O(nlog₂n)	  O(n)
     * @author ygh
     * @date 10:43
     */

    public static int[] mergingSort(int[] arr){
        if(arr.length <= 1) return arr;

        int num = arr.length >> 1;
        int[] leftArr = Arrays.copyOfRange(arr, 0, num);
        int[] rightArr = Arrays.copyOfRange(arr, num, arr.length);
        System.out.println("split two array: " + Arrays.toString(leftArr) + " And " + Arrays.toString(rightArr));
        //不断拆分为最小单元，再排序合并
        return mergeTwoArray(mergingSort(leftArr), mergingSort(rightArr));
    }

    private static int[] mergeTwoArray(int[] arr1, int[] arr2){
        int i = 0, j = 0, k = 0;
        //申请额外的空间存储合并之后的数组
        int[] result = new int[arr1.length + arr2.length];
        //选取两个序列中的较小值放入新数组
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] <= arr2[j]){
                result[k++] = arr1[i++];
            }else{
                result[k++] = arr2[j++];
            }
        }
        //序列1中多余的元素移入新数组
        while(i < arr1.length){
            result[k++] = arr1[i++];
        }
        //序列2中多余的元素移入新数组
        while(j < arr2.length){
            result[k++] = arr2[j++];
        }
        System.out.println("Merging: " + Arrays.toString(result));
        return result;
    }
    /**
     * 基数排序（LSD 从低位开始）
     *
     * 基数排序适用于：
     *  (1)数据范围较小，建议在小于1000
     *  (2)每个数值都要大于等于0
     *
     * ①. 取得数组中的最大数，并取得位数；
     * ②. arr为原始数组，从最低位开始取每个位组成radix数组；
     * ③. 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
     * @param arr    待排序数组
     */
    public static void radixSort(int[] arr){
        long start = System.currentTimeMillis();
        if(arr.length <= 1) return;

        //取得数组中的最大数，并取得位数
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        int maxDigit = 1;
        while(max / 10 > 0){
            maxDigit++;
            max = max / 10;
        }
        System.out.println("maxDigit: " + maxDigit);

        //申请一个桶空间
        int[][] buckets = new int[10][arr.length];
        int base = 10;

        //从低位到高位，对每一位遍历，将所有元素分配到桶中
        for(int i = 0; i < maxDigit; i++){
            //存储各个桶中存储元素的数量 初始化为0
            int[] bktLen = new int[10];

            //分配：将所有元素分配到桶中
            for(int j = 0; j < arr.length; j++){
                // 得到个位，十位等的值
                int whichBucket = (arr[j] % base) / (base / 10);
                // buckets 第一维表示该位数的大小，二维是存的该位大小已有的个数
                buckets[whichBucket][bktLen[whichBucket]] = arr[j];
                // 个数加一
                bktLen[whichBucket]++;
            }

            //收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            int k = 0;
            for(int b = 0; b < buckets.length; b++){
                for(int p = 0; p < bktLen[b]; p++){
                    arr[k++] = buckets[b][p];
                }
            }

            base *= 10;
        }
        long end = System.currentTimeMillis();
        System.out.println("Sorting: " + Arrays.toString(arr));
        System.out.println("time :" + (end-start));
    }

}
