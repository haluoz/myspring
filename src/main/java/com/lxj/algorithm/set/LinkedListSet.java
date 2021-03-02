package com.lxj.algorithm.set;

import com.lxj.algorithm.linkedlist.LinkedList;

/**
 * @author Administrator
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> linkedList;

    public LinkedListSet() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!linkedList.contains(e)){
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public static void main(String[] args) {
        LinkedListSet<String> set = new LinkedListSet<>();
        String [] words = {"I","am","a","student","I","was","born","in","gz","I","love","here","It","would","be","great"};
        System.out.println(words.length);
        for (String word : words) {
            set.add(word);
        }
        System.out.println(set.getSize());
    }
}
