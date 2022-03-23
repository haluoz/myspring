package com.lxj.leetcode.tree;

import org.slf4j.helpers.NOPLogger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xingjing.Li
 * @since 2022/3/14
 */
public class NaryTreePreorderTraversal589 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        dfs(root);
        return list;
    }

    private void dfs(Node root) {
        if (root == null) return;
        list.add(root.val);
        for (Node node : root.children) dfs(node);
    }

    public static void main(String[] args) {
        NaryTreePreorderTraversal589 solution = new NaryTreePreorderTraversal589();
        Node nTree = new Node(1, Arrays.asList(new Node(3, Arrays.asList(new Node(5,new ArrayList<>()), new Node(6, new ArrayList<>()))),
                new Node(2, new ArrayList<Node>()), new Node(4, new ArrayList<Node>())));
        solution.preorder(nTree);
    }
}
