package com.lxj.leetcode.linkedlist;

/**
 * @author Xingjing.Li
 * @since 2023/1/30
 */
public class MergeInBetweenLinkedLists1669 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode retNode = new ListNode();
        ListNode dummyHead = retNode;
        int index = 0;
        while (list1 != null){
            if (a<= index && index <= b){
                while (list2 != null){
                    dummyHead.val = list2.val;
                    list2 = list2.next;
                    dummyHead.next = new ListNode();
                    dummyHead = dummyHead.next;
                }
                list1 = list1.next;
            }else {
                dummyHead.val = list1.val;
                list1 = list1.next;
                if (list1 != null) {
                    dummyHead.next = new ListNode();
                    dummyHead = dummyHead.next;
                }
            }
            index++;
        }
        return retNode;
    }

    public static void main(String[] args) {
        MergeInBetweenLinkedLists1669 solution = new MergeInBetweenLinkedLists1669();
//        ListNode listNode1 = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        ListNode listNode1 = new ListNode(0, new ListNode(3, new ListNode(2, new ListNode(1, new ListNode(4, new ListNode(5))))));
        ListNode listNode2 = new ListNode(1000000, new ListNode(1000001, new ListNode(1000002)));
        solution.mergeInBetween(listNode1,3, 4, listNode2);
    }
}
