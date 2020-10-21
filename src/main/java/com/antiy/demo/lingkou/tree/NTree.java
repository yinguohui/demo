package com.antiy.demo.lingkou.tree;

/**
 * @Author ygh
 * @Description n叉树
 *
 * 各种数据结构的遍历 + 访问无非两种形式：线性的和非线性的。
 *
 * 线性就是 for/while 迭代为代表，非线性就是递归为代表。再具体一步，无非以下几种框架：
 *
 * 数组遍历框架，典型的线性迭代结构：
 * void traverse(int[] arr) {
 *     for (int i = 0; i < arr.length; i++) {
 *         // 迭代访问 arr[i]
 *     }
 * }
 *
 * 链表遍历框架，兼具迭代和递归结构：
 * class ListNode {
 *     int val;
 *     ListNode next;
 * }
 *
 * void traverse(ListNode head) {
 *     for (ListNode p = head; p != null; p = p.next) {
 *         // 迭代访问 p.val
 *     }
 * }
 *
 * void traverse(ListNode head) {
 *     // 递归访问 head.val
 *     traverse(head.next)
 * }
 *
 * 二叉树遍历框架，典型的非线性递归遍历结构：
 *
 * class TreeNode {
 *     int val;
 *     TreeNode left, right;
 * }
 *
 * void traverse(TreeNode root) {
 *  // 前序遍历
 *     traverse(root.left)
 *        // 中序遍历
 *     traverse(root.right)
 *         // 后序遍历
 * }
 * @Date 2020/9/16
 */
public class NTree {
    private String val;
    private NTree[] trees;

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public NTree[] getTrees() {
        return trees;
    }

    public void setTrees(NTree[] trees) {
        this.trees = trees;
    }

    public static void traverse(NTree nTree){
//        前序
//        System.out.println(nTree.getVal());
        if (nTree.getTrees()!=null){
            for (int i = 0; i < nTree.trees.length; i++) {
                traverse(nTree.trees[i]);
            }
        }
//        后续
//        System.out.println(nTree.getVal());
    }

    public static void main(String[] args) {
        NTree nTree = new NTree();
        nTree.setVal("1");
        NTree nTree1 = new NTree();
        nTree1.setVal("2");
        NTree nTree2 = new NTree();
        nTree2.setVal("3");
        NTree[] a = {nTree1,nTree2};

        NTree nTree3 = new NTree();
        nTree3.setVal("4");
        NTree nTree4 = new NTree();
        nTree4.setVal("5");
        NTree[] a1 = {nTree3,nTree4};

        NTree nTree5 = new NTree();
        nTree5.setVal("6");
        NTree nTree6 = new NTree();
        nTree6.setVal("7");
        NTree[] a2 = {nTree5,nTree6};

        nTree.setTrees(a);
        nTree1.setTrees(a1);
        nTree2.setTrees(a2);
        traverse(nTree);
    }
}
