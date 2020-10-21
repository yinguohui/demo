package com.antiy.demo.lingkou;

/**
 * @Author ygh
 * @Description 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * <p>
 * 请返回 nums 的动态和
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 * @Date 2020/9/15
 */
public class Solution1480 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        answer1(nums);
    }

    public static void answer1(int[] a) {
        int[] b = new int[a.length];
        b[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            b[i] = a[i] + b[i - 1];
        }
        System.out.print("[");
        for (int i = 0; i < b.length - 1; i++) {
            System.out.print(b[i] + ",");
        }
        System.out.print(b[b.length - 1]);
        System.out.print("]");
    }
}
