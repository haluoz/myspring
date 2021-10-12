package com.lxj.leetcode.linkedlist;

/**
 * @author Xingjing.Li
 * @since 2021/9/30
 */
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode firstP = head, sencondP = head;
        for (int i = 0; i < k; i++) {
            firstP = firstP.next;
        }
        while (firstP != null){
            firstP = firstP.next;
            sencondP = sencondP.next;
        }
        return sencondP;
    }

    public static void main(String[] args) {
        GetKthFromEnd solution = new GetKthFromEnd();
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        solution.getKthFromEnd(node, 2);
    }
}
