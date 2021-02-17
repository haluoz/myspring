package com.lxj.algorithm.recursion;

import com.lxj.algorithm.linkedlist.LinkedList;

/**
 * 递归删除linkedList元素
 * @author Administrator
 */
public class RemoveLinkedListElements {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int [] arr) {
            if (arr == null){
                throw new IllegalArgumentException("array is empty");
            }
            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LinkedList: ");
            ListNode cur = this;
            while (cur != null){
                sb.append(cur.val+"->");
                cur = cur.next;
            }
            sb.append("Null");
            return sb.toString();
        }
    }

    public ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generateDepth(depth);
        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in "+ head);
        if (head == null){
            System.out.print(depthString);
            System.out.println("Return: "+ head);
            return null;
        }
        ListNode res = removeElements(head.next, val, depth+1);
        System.out.print(depthString);
        System.out.println("After: remove " + val + ": "+ res);
        ListNode retNode;
        if (head.val == val){
            retNode = res;
        }else {
            head.next = res;
            retNode = head;
        }
        System.out.print(depthString);
        System.out.println("Return: "+ retNode);
        return retNode;
    }

    private String generateDepth(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int [] arr = {1,2,6,3,4,5,6};
        ListNode listNode = new RemoveLinkedListElements.ListNode(arr);
        new RemoveLinkedListElements().removeElements(listNode, 6 ,0);
    }
}
