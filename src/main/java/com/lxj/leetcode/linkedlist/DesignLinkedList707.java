package com.lxj.leetcode.linkedlist;

/**
 *
 */
public class DesignLinkedList707 {

    private ListNode dummyHead;
    private int size;

    public DesignLinkedList707() {
        dummyHead = new ListNode(-1,null);
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        return prev.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new ListNode(val, prev.next);
        size++;
    }


    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//        prev = prev.next;
        ListNode retNode = prev.next;
        prev.next = retNode.next;
        size--;
    }


    public static void main(String[] args) {
        DesignLinkedList707 solution = new DesignLinkedList707();
        solution.addAtHead(1);
        solution.addAtHead(2);
        solution.addAtTail(5);
        solution.addAtIndex(2, 4);
        System.out.println(solution.get(2));
        solution.deleteAtIndex(1);
    }
}
