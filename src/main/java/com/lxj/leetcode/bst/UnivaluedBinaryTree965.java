package com.lxj.leetcode.bst;

import java.util.ArrayList;

/**
 * @author Xingjing.Li
 * @since 2022/5/25
 */
public class UnivaluedBinaryTree965 {
    ArrayList<Integer> list = new ArrayList<>();
    public boolean isUnivalTree(TreeNode root) {
        dfs(root);
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(list.get(i + 1))){
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode node){
        if (node == null){
            return;
        }
        list.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }

    int val = -1;
    public boolean isUnivalTree1(TreeNode root) {
        if (val == -1) val = root.val;
        if (root == null) return true;
        if (root.val != val) return false;
        return isUnivalTree1(root.left) && isUnivalTree1(root.right);
    }


    public static void main(String[] args) {
        UnivaluedBinaryTree965 solution = new UnivaluedBinaryTree965();
        TreeNode root = new TreeNode(1, new TreeNode(1, new TreeNode(1), new TreeNode(1)), new TreeNode(1, null, new TreeNode(2)));
        solution.isUnivalTree1(root);
    }
}
