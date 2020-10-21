package com.antiy.demo.lingkou.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TreeNode<K,V> {
    TreeNode<K, V> parent;
    TreeNode<K, V> left;
    TreeNode<K, V> right;
    TreeNode<K, V> prev;
    boolean red;

    public TreeNode(TreeNode<K, V> parent, TreeNode<K, V> left, TreeNode<K, V> right, TreeNode<K, V> prev, boolean red) {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.prev = prev;
        this.red = red;
    }

    /**
     * Returns root of tree containing this node.
     */
    final TreeNode<K, V> root() {
        for (TreeNode<K, V> r = this, p; ; ) {
            if ((p = r.parent) == null){
                return r;
            }
            r = p;
        }
    }

    static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        @Override
        public final String toString() {
            return key + "=" + value;
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }
    public static void put(TreeNode node,TreeNode in){

    }

    public static TreeNode treeFiy(List<Node> list){
        return null;
    }

    public static void main(String[] args) {

    }
}