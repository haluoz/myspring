package leetcode;

import java.util.*;

public class BalancedBinarySearchTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    TreeNode root;

    public BalancedBinarySearchTree() {
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return (Math.abs(dfs(root.left, 1) - dfs(root.right, 1)) < 2)
                && (isBalanced(root.left) && isBalanced(root.right));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> retList = new ArrayList<>();
        if(root != null){
            queue.add(root);
        }
        int i = 1;
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int j =queue.size();j>0; j--){
                TreeNode cur = queue.remove();
                list.add(cur.val);
                if(cur.right != null){
                    queue.add(cur.right);
                }
                if(cur.left != null){
                    queue.add(cur.left);
                }
            }
            if (1%2 == 0){
                Collections.reverse(list);
            }
            retList.add(list);
            i++;
        }
        return retList;
    }

    private int dfs(TreeNode root, int curDepth) {
        if (root == null) {
            return curDepth;
        }
        curDepth++;
        return Math.max(dfs(root.left, curDepth), dfs(root.right, curDepth));
    }

    public static void main(String[] args) {
        BalancedBinarySearchTree tree = new BalancedBinarySearchTree();
        System.out.println(tree.isBalanced(tree.root));
        System.out.println(tree.levelOrder(tree.root).toString());
    }
}
