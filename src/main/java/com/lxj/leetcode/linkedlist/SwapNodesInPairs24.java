package com.lxj.leetcode.linkedlist;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 */
public class SwapNodesInPairs24 {

    private ListNode root;

    public SwapNodesInPairs24() {
        root = new ListNode(1, new ListNode(2,new ListNode(3, new ListNode(4))));
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummyHead = new ListNode(1, head);
        ListNode temp = dummyHead;
        while(temp.next != null && temp.next.next != null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs24 solution = new SwapNodesInPairs24();
        solution.swapPairs(solution.root);
    }
}
