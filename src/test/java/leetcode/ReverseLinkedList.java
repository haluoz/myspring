package leetcode;

public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        public boolean add(ListNode node){
            next = node;
            return true;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            //指向前一个节点
            curr.next = prev;
            //prev指向curr prev向后移
            prev = curr;
            //curr指向nex curr向后移
            curr = next;
        }
        return prev;
    }

    public static ListNode reverseListRecursion(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode rev = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        int size = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            size++;
        }
        int times = size - k;
        int  i = 0;
        while(head != null){
            head = head.next;
            i++;
            if(i == times){
                return head;
            }
        }
        return null;
    }

    public static ListNode getKthFromEndByDoublePointer(ListNode head, int k) {
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

    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode cur = head;
        while (cur.next != null && cur.next.val != val)
            cur = cur.next;
        if (cur.next != null)
            cur.next = cur.next.next;
        return head;
    }


    public static void main(String[] args) {
        ReverseLinkedList.ListNode node1 = new ReverseLinkedList.ListNode(1);
        ReverseLinkedList.ListNode node2 = new ReverseLinkedList.ListNode(2);
        ReverseLinkedList.ListNode node3 = new ReverseLinkedList.ListNode(3);
        ReverseLinkedList.ListNode node4 = new ReverseLinkedList.ListNode(4);
        ReverseLinkedList.ListNode node5 = new ReverseLinkedList.ListNode(5);
        node1.add(node2);
//        node2.add(node4);
        node2.add(node3);
        node3.add(node4);
        node4.add(node5);
//        ReverseLinkedList.getKthFromEnd(node1,1);
//        ReverseLinkedList.getKthFromEndByDoublePointer(node1, 1);
//        ReverseLinkedList.deleteNode(node1, 4);
        ReverseLinkedList.ListNode reversed = ReverseLinkedList.reverseListRecursion(node1);
//        ReverseLinkedList.ListNode cur = reversed;
//        while (reversed != null){
//            System.out.println(reversed.val);
//            reversed = reversed.next;
//        }

    }
}
