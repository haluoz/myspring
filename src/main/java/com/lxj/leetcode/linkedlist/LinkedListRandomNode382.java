package com.lxj.leetcode.linkedlist;

import java.util.Random;

/**
 * @author Xingjing.Li
 * @since 2022/1/17
 */
public class LinkedListRandomNode382 {
    private ListNode dummyHead = new ListNode(-1);
    private int size = 0;
    private Random random = new Random();

    public LinkedListRandomNode382(ListNode head) {
        ListNode node = this.dummyHead;
        while(head != null){
            node.next = new ListNode(head.val);
            size++;
            head = head.next;
            node = node.next;
        }
    }

    public int getRandom() {
        ListNode node = dummyHead.next;
        int randomNum = random.nextInt(size);
        for(int i = 0; i< randomNum; i++){
            node = node.next;
        }
        return node.val;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3)));
        LinkedListRandomNode382 solution = new LinkedListRandomNode382(listNode);
        solution.getRandom();
        solution.getRandom();
        solution.getRandom();
        solution.getRandom();
        solution.getRandom();
    }
}
