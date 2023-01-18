package com.lxj.leetcode.tree;

import java.util.*;

/**
 * @author Xingjing.Li
 * @since 2022/4/24
 */
public class NaryTreeLevelOrderTraversal429 {
    private List<List<Integer>> ansList = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        Deque<Node> deque = new ArrayDeque<>();
        if (root != null){
            deque.addLast(root);
        }
        while (!deque.isEmpty()){
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                Node t = deque.pollFirst();
                for (Node node : t.children) deque.addLast(node);
                list.add(t.val);
            }
            ansList.add(list);
        }
        return ansList;
    }


    public static void main(String[] args) {
        NaryTreeLevelOrderTraversal429 solution = new NaryTreeLevelOrderTraversal429();
        Node nTree = new Node(1, Arrays.asList(new Node(3, Arrays.asList(new Node(5,new ArrayList<>()), new Node(6, new ArrayList<>()))),
                new Node(2, new ArrayList<Node>()), new Node(4, new ArrayList<Node>())));
        solution.levelOrder(nTree);
    }
}
