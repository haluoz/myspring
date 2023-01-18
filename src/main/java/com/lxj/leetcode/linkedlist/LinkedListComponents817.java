package com.lxj.leetcode.linkedlist;

import java.util.HashSet;

/**
 * @author Xingjing.Li
 * @since 2022/10/12
 */
public class LinkedListComponents817 {

    public int numComponents(ListNode head, int[] nums) {
        int num = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        while (head != null){
            if (set.contains(head.val)) {
                while (head != null && set.contains(head.val)){
                    head = head.next;
                }
                num++;
            }else{
                head = head.next;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3))));
        int[] ints = {0, 1, 3};
        LinkedListComponents817 solution = new LinkedListComponents817();
        System.out.println(solution.numComponents(head, ints));
    }
}
