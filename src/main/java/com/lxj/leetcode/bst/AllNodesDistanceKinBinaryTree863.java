package com.lxj.leetcode.bst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xingjing.Li
 * @since 2021/7/28
 */
public class AllNodesDistanceKinBinaryTree863 {
    Map<Integer, TreeNode> parents = new HashMap<Integer, TreeNode>();
    List<Integer> ans = new ArrayList<Integer>();
    private TreeNode root;

    public AllNodesDistanceKinBinaryTree863() {
        root = new TreeNode(3);
        TreeNode left = new TreeNode(5, new TreeNode(6), null);
        TreeNode right = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        root.left = left;
        root.right = right;
        TreeNode leftRight = new TreeNode(2, new TreeNode(7), new TreeNode(4));
        left.right = leftRight;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 从 root 出发 DFS，记录每个结点的父结点
        findParents(root);

        // 从 target 出发 DFS，寻找所有深度为 k 的结点
        findAns(target, null, 0, k);
        return ans;
    }

    public void findParents(TreeNode node) {
        if (node.left != null) {
            parents.put(node.left.val, node);
            findParents(node.left);
        }
        if (node.right != null) {
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }

    public void findAns(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) {
            return;
        }
        if (depth == k) {
            ans.add(node.val);
            return;
        }
        if (node.left != from) {
            findAns(node.left, node, depth + 1, k);
        }
        if (node.right != from) {
            findAns(node.right, node, depth + 1, k);
        }
        if (parents.get(node.val) != from) {
            findAns(parents.get(node.val), node, depth + 1, k);
        }
    }

    public static void main(String[] args) {
        AllNodesDistanceKinBinaryTree863 solution = new AllNodesDistanceKinBinaryTree863();
        System.out.println(solution.distanceK(solution.root, solution.root.left, 2).size());
    }
}
