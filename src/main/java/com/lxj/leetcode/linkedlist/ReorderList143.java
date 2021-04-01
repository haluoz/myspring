package com.lxj.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ReorderList143 {
    private ListNode root;

    public ReorderList143() {
        root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    }

    public void reorderList(ListNode head) {
        if(head == null){
            return ;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode linear = head;
        while(linear != null){
            list.add(linear);
            linear = linear.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    public static void main(String[] args) {
        ReorderList143 solution = new ReorderList143();
        solution.reorderList(solution.root);
    }
}
