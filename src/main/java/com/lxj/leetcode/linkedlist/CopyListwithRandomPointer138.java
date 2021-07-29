package com.lxj.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Random;

/**
 * @author Xingjing.Li
 * @since 2021/7/28
 */
public class CopyListwithRandomPointer138 {
    private Node root;

    public CopyListwithRandomPointer138() {
        root = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1.random = root;
        node2.random = node4;
        node3.random = node2;
        node4.random = root;
//        Random random = new Random();
//        Node gen = root;
//        for (int i = 0; i < 4; i++) {
//            if (i == 1){
//                gen.random = root;
//            }
//            Node node = new Node(random.nextInt(20)+1);
//            gen.next = node;
//            gen = gen.next;
//        }
    }

    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            Node node = map.get(cur);
            node.next = map.get(cur.next);
            node.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node dummy = new Node(-1);
        dummy.next = head;
        while (head != null) {
            Node node = new Node(head.val);
            node.next = head.next;
            head.next = node;
            head = node.next;
        }
        head = dummy.next;
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
        head = dummy.next;
        Node ans = head.next;
        while (head != null) {
            Node tmp = head.next;
            if (head.next != null) head.next = head.next.next;
            head = tmp;
        }
        return ans;
    }

    public static void main(String[] args) {
        CopyListwithRandomPointer138 solution = new CopyListwithRandomPointer138();
        solution.copyRandomList(solution.root);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
