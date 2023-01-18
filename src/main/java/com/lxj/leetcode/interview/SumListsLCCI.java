package com.lxj.leetcode.interview;


import com.lxj.leetcode.linkedlist.ListNode;

public class SumListsLCCI {

    private ListNode l1;
    private ListNode l2;

    public SumListsLCCI() {
        l1 = new ListNode(7, new ListNode(1, new ListNode(6)));
        l2 = new ListNode(5, new ListNode(9, new ListNode(2)));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;//求两个节点相加的值
            carry = sum / 10;//取进位的值
            prev.next = new ListNode(sum % 10);//sum对10求余后放到节点中
            prev = prev.next;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        SumListsLCCI solution = new SumListsLCCI();
        solution.addTwoNumbers(solution.l1, solution.l2);
    }
}
