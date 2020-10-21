package com.antiy.demo.lingkou.tree;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @Author ygh
 * @Description
 *  从前序与中序遍历序列构造二叉树
 *  前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @Date 2020/9/17
 */
public class Solution105 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        public void setVal(int val) {
            this.val = val;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    public static void main(String[] args) {
//        int[] a = {3,9,20,15,7};
//        int[] b = {9,3,15,20,7};
        int[] a = {3,9,10,11,12};
        int[] b = {10,9,11,3,12};
        System.out.println(answer(a,b,0,a.length));
    }

    public static TreeNode answer(int[] preorder , int[] inorder,int start,int end){
        TreeNode node = null;
        if (start>=end){
            return node;
        }
        node = new TreeNode(preorder[start]);
        int step1 = 0;
        for (int i = 0; i < end; i++) {
            if (inorder[i]==preorder[start]){
                step1 = i;
                break;
            }
        }
        node.left = answer(preorder,inorder,start+1,step1);
        node.right = answer(preorder,inorder,step1+1,end);
        return node;
    }
}
