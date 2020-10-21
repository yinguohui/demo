package com.antiy.demo.lingkou.tree;

/**
 * @Author ygh
 * @Description 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * @Date 2020/9/23
 */
public class Solution617 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode a;

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return test(t1, t2);
    }

    public TreeNode test(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode t = null;
        if (t1 == null && t2 != null) {
            t = new TreeNode(t2.val);
            t.left = test(null, t2.left);
            t.right = test(null, t2.right);
        }
        if (t1 != null && t2 == null) {
            t = new TreeNode(t1.val);
            t.left = test(t1.left, null);
            t.right = test(t1.right, null);
        }
        if (t1 != null && t2 != null) {
            t = new TreeNode(t2.val + t1.val);
            t.left = test(t1.left, t2.left);
            t.right = test(t1.right, t2.right);
        }
        return t;
    }

    public TreeNode test1(TreeNode t1, TreeNode t2) {

        TreeNode t = null;
        if (t1 == null) {
           return t2;
        }
        if ( t2 == null) {
           return t1;
        }
        t = new TreeNode(t2.val + t1.val);
        t.left = test1(t1.left, t2.left);
        t.right = test1(t1.right, t2.right);
        return t;
    }
}
