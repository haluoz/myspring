package com.lxj.leetcode.linkedlist;

/**
 * @author lee
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

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
