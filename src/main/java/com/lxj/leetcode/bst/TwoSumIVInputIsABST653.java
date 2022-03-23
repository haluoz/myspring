package com.lxj.leetcode.bst;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xingjing.Li
 * @since 2022/3/21
 */
public class TwoSumIVInputIsABST653 {
    private Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(k-root.val)) return true;
        set.add(root.val);
        //递归查找
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    public static void main(String[] args) {
        TwoSumIVInputIsABST653 solution = new TwoSumIVInputIsABST653();
        TreeNode root = new TreeNode(5,
                new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(6, null, new TreeNode(7)));
        solution.findTarget(root,9);
    }
}
