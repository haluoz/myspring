package com.lxj.leetcode.linkedlist;

/**
 * @author lee
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public void printLinkedList(ListNode node){
        while (node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("null");
    }
}
