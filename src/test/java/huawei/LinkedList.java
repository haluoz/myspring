package huawei;

import java.util.Scanner;

/**
 * 从单向链表中删除指定值的节点
 */
public class LinkedList {
    private  Node<Integer> head;

    private class Node<E>{
        int value;
        Node<E> next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public void add(int value, int node){
        Node<Integer> p = head;
        Node<Integer> newNode = new Node<>(value);
        p.next = newNode;
    }

    public void delete(){

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = Integer.parseInt(sc.next());
            int val = Integer.parseInt(sc.next());
        }
    }
}
