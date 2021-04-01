package com.lxj.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class PalindromeLinkedList234 {

    public PalindromeLinkedList234() {
        root = new ListNode(1,new ListNode(2,new ListNode(3, new ListNode(4, new ListNode(5 )))));
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while(head!= null){
            list.add(head.val);
            head = head.next;
        }
        int front = 0;
        int tail = list.size()-1;
        while( front < tail){
            if(list.get(front) != list.get(tail)){
                return false;
            }
            front++;
            tail--;
        }
        return true;
    }

    public ListNode middleNode(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }



    private ListNode root;

    public static void main(String[] args) {
        PalindromeLinkedList234 solution = new PalindromeLinkedList234();
        solution.isPalindrome(solution.root);
        solution.middleNode(solution.root);
    }
}
