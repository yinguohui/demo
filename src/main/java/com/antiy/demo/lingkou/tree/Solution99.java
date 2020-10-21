package com.antiy.demo.lingkou.tree;

/**
 * @Author ygh
 * @Description . 恢复二叉搜索树
 *
 * 二叉搜索树中的两个节点被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 *
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 * @Date 2020/9/17
 */
public class Solution99 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
      TreeNode pre,s1,s2;
    public void recoverTree(TreeNode root) {
        answer(root);
        int v = s1.val;
        s1.val = s2.val;
        s2.val = v;
    }

    public  void answer(TreeNode treeNode){

        answer(treeNode.left);
        if (pre!= null && treeNode.val < pre.val) {
           if (s1 == null){
               s1 = treeNode;
           }
           s2 = treeNode;

        }
        pre = treeNode;
        answer(treeNode.right);

    }
}
