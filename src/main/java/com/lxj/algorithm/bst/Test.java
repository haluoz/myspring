package com.lxj.algorithm.bst;

public class Test {
    public static void main(String[] args) {
        int [] nums = {9,3,20,15,21};
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int i = 0; i < nums.length; i++) {
            tree.addRecursion(nums[i]);
        }
        tree.maxDepth(tree.getRoot());
        tree.preOrderRecursion();
        tree.mirrorTree(tree.getRoot());
        tree.preOrderRecursion();
    }
}
