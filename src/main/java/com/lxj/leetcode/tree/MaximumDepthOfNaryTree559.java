package com.lxj.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xingjing.Li
 * @since 2021/11/23
 */
public class MaximumDepthOfNaryTree559 {
    private int maxDepth = 1;
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int depth = 1;
        dfs(root,depth);
        return maxDepth + 1;
    }

    public void dfs(Node node, int depth){
        System.out.println(node.children == null ? true : false);
        if (node == null || node.children == null) {
            return;
        }
        System.out.println("深度："+depth+"，node值："+node.val);
        maxDepth = depth > maxDepth  ? depth : maxDepth;
        for (Node child : node.children) {
            dfs(child, depth+1);
        }
    }

    public static void main(String[] args) {
        MaximumDepthOfNaryTree559 solution = new MaximumDepthOfNaryTree559();
        Node root = new Node(1, Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))),
                new Node(2), new Node(4)));
        System.out.println(solution.maxDepth(root));
    }
}
