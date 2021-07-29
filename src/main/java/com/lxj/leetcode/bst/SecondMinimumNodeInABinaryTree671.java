package com.lxj.leetcode.bst;

import java.util.*;

/**
 * @author Xingjing.Li
 * @since 2021/7/28
 */
public class SecondMinimumNodeInABinaryTree671 {

    Set<Integer> set = new HashSet<>();

    TreeNode root;

    int ans = -1;

    public SecondMinimumNodeInABinaryTree671() {
        root = new TreeNode(1,
                new TreeNode(1, new TreeNode(1), new TreeNode(3)),
                new TreeNode(3 , new TreeNode(1), new TreeNode(2)));
    }

    public int findSecondMinimumValue1(TreeNode root) {
        preOrder(root);
        if (set.size() < 2){
            return -1;
        }
//        ArrayList<Integer> integers = new ArrayList<>(set);
//        Collections.sort(integers);
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int i : set) {
            if (i <= first) {
                second = first;
                first = i;
            } else if (i <= second) {
                second = i;
            }
        }
        return second;
    }

    private void preOrder(TreeNode node){
        if (node == null){
            return;
        }
        set.add(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root, root.val);
        return ans;
    }

    void dfs(TreeNode root, int cur) {
        if (root == null) return ;
        if (root.val != cur) {
            if (ans == -1) ans = root.val;
            else ans = Math.min(ans, root.val);
            return ;
        }
        dfs(root.left, cur);
        dfs(root.right, cur);
    }

    public static void main(String[] args) {
        SecondMinimumNodeInABinaryTree671 solution = new SecondMinimumNodeInABinaryTree671();
        System.out.println(solution.findSecondMinimumValue(solution.root));
    }
}
