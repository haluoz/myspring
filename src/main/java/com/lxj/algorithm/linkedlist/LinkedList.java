package com.lxj.algorithm.linkedlist;

import com.lxj.algorithm.map.LinkedListMap;

/**
 * @author Administrator
 */
public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node() {
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void set(int index, E e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public E get(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
//        size++;
        add(0, e);
    }

    public void add(int index, E e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index ; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public void addLast(int index, E e){
        add(size, e);
    }

    public E remove(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    //my implementation
    public E removeElementMy(E e){
        Node curNode = dummyHead.next.next;
        Node prevNode = dummyHead.next;
        while (curNode != null && !curNode.e.equals(e)) {
            prevNode = curNode;
            curNode = curNode.next;
        }
        E ret = curNode.e;
        prevNode.next = curNode.next;
        return ret;
    }

    //bobo implementation
    public E removeElement(E e){
        Node prev = dummyHead;
        while (prev.next != null){
            if (prev.next.e.equals(e)){
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            return delNode.e;
        }
        return  null;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList: ");
        Node cur = dummyHead.next;
        while (cur != null){
            sb.append(cur+"->");
            cur = cur.next;
        }
        sb.append("Null");
        return sb.toString();
    }

    public Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null) {
            return null;
        }
        Node n1 = headA;
        Node n2 = headB;

        while(n1 != n2){
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }
        return n1;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

//        for (int i = 0; i < 5; i++) {
//            linkedList.addFirst(i);
//            System.out.println(linkedList);
//        }
//        linkedList.add(2, 666);
//        System.out.println(linkedList);
//        linkedList.remove(2);
//        System.out.println(linkedList);
//        linkedList.removeFirst();
//        System.out.println(linkedList);
//        linkedList.removeElement(666);
//        System.out.println(linkedList);
    }
}
