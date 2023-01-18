package com.lxj.leetcode.bst;

/**
 * @author Xingjing.Li
 * @since 2022/6/9
 */
public class SumOfRootToLeafBinaryNumbers1022 {

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    int dfs(TreeNode root, int cur) {
        int ans = 0, ncur = (cur << 1) + root.val;
        if (root.left != null) ans += dfs(root.left, ncur);
        if (root.right != null) ans += dfs(root.right, ncur);
        return root.left == null && root.right == null ? ncur : ans;
    }

    public static void main(String[] args) {
        SumOfRootToLeafBinaryNumbers1022 solution = new SumOfRootToLeafBinaryNumbers1022();
        TreeNode node = new TreeNode(1,
                new TreeNode(0, new TreeNode(0), new TreeNode(1)),
                new TreeNode(1, new TreeNode(0), new TreeNode(1)));
        System.out.println(solution.sumRootToLeaf(node));
    }
}
