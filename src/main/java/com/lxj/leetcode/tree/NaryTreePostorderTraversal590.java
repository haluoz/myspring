package com.lxj.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xingjing.Li
 * @since 2022/3/14
 */
public class NaryTreePostorderTraversal590 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorder(Node root) {


        return list;
    }

    public static void main(String[] args) {
        NaryTreePostorderTraversal590 solution = new NaryTreePostorderTraversal590();
        Node nTree = new Node(1, Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))),
                new Node(2), new Node(4)));
        solution.postorder(nTree);
    }
}
