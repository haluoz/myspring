package com.lxj.algorithm.linkedlist;

/**
 * 双向链表
 * @author Xingjing.Li
 * @since 2021/10/21
 */
public class DoublyLinkedList<E> {
    private class Node{
        E val;
        Node next, prev;

        public Node(E val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        public Node(E val) {
            this(val, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val + "}";
        }
    }

    private Node dummyHead;
    private int size;

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.val.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E get(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addLast(E e){
        Node cur = dummyHead;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
        }
        Node node = new Node(e, null, cur);
        cur.next = node;
        size++;
    }

    public void addFirst(E e){
        Node cur = dummyHead;
        if (cur.next == null){
            Node node = new Node(e, null, cur);
            cur.next = node;
        }else{
            Node next = cur.next;
            Node node = new Node(e, next, dummyHead);
            next.prev = node;
            dummyHead.next = node;
        }
        size++;
    }

    public void removeFirst(){
        Node cur = dummyHead;
        Node next = cur.next;
        next.prev = null;
        next.next.prev = cur;
        cur.next = next.next;
        next.next = null;
        size--;
    }

    public void removeLast(){
        Node cur = dummyHead;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
        }
        Node prev = cur.prev;
        cur.prev = null;
        prev.next = null;
        size--;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(0);
//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
        list.addLast(11);
        list.addLast(22);
        list.addLast(33);
        list.addLast(44);
        list.addFirst(1);
        list.removeLast();
        list.removeFirst();
    }

    public DoublyLinkedList(E val) {
        this.dummyHead = new Node(val, null, null);
        this.size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            sb.append(cur+"->");
            cur = cur.next;
        }
        sb.append("Null");
        return sb.toString();
    }
}
