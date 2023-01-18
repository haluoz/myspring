package com.lxj.leetcode.bst;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees872 {

    private TreeNode root1;
    private TreeNode root2;

    public LeafSimilarTrees872() {
        root1 = new TreeNode(3,
                new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                new TreeNode(1, new TreeNode(9), new TreeNode(8)));
        root2 = new TreeNode(3,
                new TreeNode(5, new TreeNode(6), new TreeNode(7)),
                new TreeNode(1, new TreeNode(4), new TreeNode(2, new TreeNode(9), new TreeNode(8))));
//        root1 = new TreeNode(1, new TreeNode(2), null);
//        root1 = new TreeNode(2, new TreeNode(2), null);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> firstLeaves = new ArrayList<>();
        if (root1 != null){
            inOrder(root1, firstLeaves);
        }
        ArrayList<Integer> secondLeaves = new ArrayList<>();
        if (root2 != null){
            inOrder(root2, secondLeaves);
        }
        return firstLeaves.equals(secondLeaves);
    }

    private void inOrder(TreeNode node, List<Integer> leaves){
        if (node == null){
            return;
        }
        if (node.left == null && node.right == null){
            leaves.add(node.val);
            return;
        }
        inOrder(node.left, leaves);
        inOrder(node.right,leaves);
    }

    public static void main(String[] args) {
        LeafSimilarTrees872 solution = new LeafSimilarTrees872();
        solution.leafSimilar(solution.root1, solution.root2);
    }
}
