package com.antiy.demo.lingkou;

/**
 * Definition for ListNode
 */

public class Solution {
    /**
     * @param head: the first node of linked list.
     * @return: An integer
     */
    public static int countNodes(ListNode head) {
        // write your code here
        int c = 0;
        if (head == null){
           return c;
        }
        c++;
        while ((head = head.next )!= null){
            c++;
        }
        System.out.println(c);
        return c;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode node = null;
        countNodes(node);
    }
}