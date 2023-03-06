package com.lxj.leetcode.bst;

/**
 * @author Xingjing.Li
 * @since 2023/2/6
 */
public class EvaluateBooleanBinaryTree2331 {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null){
            return root.val == 1;
        }
        //或者并且判断
        if (root.val == 2){
            return evaluateTree(root.left) || evaluateTree(root.right);
        }else{
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }

    public static void main(String[] args) {
        EvaluateBooleanBinaryTree2331 solution = new EvaluateBooleanBinaryTree2331();
        TreeNode treeNode = new TreeNode(2, new TreeNode(1), new TreeNode(3, new TreeNode(0), new TreeNode(1)));
        System.out.println(solution.evaluateTree(treeNode));
    }
}
