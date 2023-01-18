package com.lxj.leetcode.bst;

/**
 * @author Xingjing.Li
 * @since 2022/7/1
 */
public class BinaryTreeTilt563 {

    public static void main(String[] args) {
        BinaryTreeTilt563 solution = new BinaryTreeTilt563();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(solution.findTilt(root));
    }

    int ans = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left), r = dfs(root.right);
        ans += Math.abs(l - r);
        return l + r + root.val;
    }

}
