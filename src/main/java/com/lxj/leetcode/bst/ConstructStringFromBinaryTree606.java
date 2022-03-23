package com.lxj.leetcode.bst;

/**
 * @author Xingjing.Li
 * @since 2022/3/21
 */
public class ConstructStringFromBinaryTree606 {
    private StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode root) {
        dfs(root);
        return sb.substring(1, sb.length()-1);
    }

    private void dfs(TreeNode node){
        if (node == null) return;
        sb.append("(");
        sb.append(node.val);
        if (node.left != null){
            dfs(node.left);
        }else if (node.right != null){
            sb.append("()");
        }
        if (node.right != null){
            dfs(node.right);
        }
        sb.append(")");
    }

    public static void main(String[] args) {
        ConstructStringFromBinaryTree606 solution = new ConstructStringFromBinaryTree606();
        TreeNode node = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
        System.out.println(solution.tree2str(node));
    }
}
