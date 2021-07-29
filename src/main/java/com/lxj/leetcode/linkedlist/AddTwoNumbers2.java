package com.lxj.leetcode.linkedlist;

public class AddTwoNumbers2 {
    ListNode l1;
    ListNode l2;
    public AddTwoNumbers2() {
        l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9)))))));
        l2 = new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9))));
    }

    public static void main(String[] args) {
        AddTwoNumbers2 solution = new AddTwoNumbers2();
        ListNode listNode = solution.addTwoNumbers(solution.l1, solution.l2);
        listNode.printLinkedList(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] nums = new int[999];
        int size = 0;
        ListNode retNode = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y+ carry;
            carry = sum / 10;
            sum = sum % 10;
            nums[size++] = sum;
            if (l1 != null)
                l1 = l1.next;
            if(l2!= null)
                l2 = l2.next;
        }
        ListNode tempNode = new ListNode(nums[0]);
        retNode = tempNode;
        for (int k = 1; k < size ; k++) {
            tempNode.next = new ListNode(nums[k]);
            tempNode = tempNode.next;
        }
        if(carry > 0) {
            tempNode.next = new ListNode(carry);
        }
        return retNode;
    }
}
