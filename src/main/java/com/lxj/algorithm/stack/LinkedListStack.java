package com.lxj.algorithm.stack;

import com.lxj.algorithm.linkedlist.LinkedList;

/**
 * @author Administrator
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList = new LinkedList<>();

    @Override
    public void push(E val) {
        linkedList.addFirst(val);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        return "LinkedListStack{" +
                "linkedList=" + linkedList +
                '}';
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
