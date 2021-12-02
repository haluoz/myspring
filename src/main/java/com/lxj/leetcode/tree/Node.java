package com.lxj.leetcode.tree;

import java.util.List;

/**
 * @author Xingjing.Li
 * @since 2021/11/23
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
