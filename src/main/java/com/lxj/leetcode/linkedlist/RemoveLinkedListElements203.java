package com.lxj.leetcode.linkedlist;

/**
 * 给你一个链表的头节点 head 和一个整数 val
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 */
public class RemoveLinkedListElements203 {

    //用虚拟头节点
    public ListNode removeElements(ListNode head, int val, boolean isDummy) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode dummyHead = dummy;
        while(dummyHead.next != null){
            if(dummyHead.next.val == val){
                dummyHead.next = dummyHead.next.next;
            }else{
                dummyHead = dummyHead.next;
            }
        }
        return dummy.next;
    }

    //不用虚拟头节点
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        while(head != null && head.val == val){
            ListNode delNode = head;
            head = delNode.next;
            delNode.next = null;
        }
        ListNode prev = head;
        while(prev != null && prev.next != null){
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else{
                prev = prev.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
    }
}
