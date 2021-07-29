package com.lxj.leetcode.linkedlist;

import java.util.LinkedList;

public class DesignHashSet705 {
    private LinkedList<Integer> list;

    /** Initialize your data structure here. */
    public DesignHashSet705() {
        list = new LinkedList<>();
    }

    public void add(int key) {
        if(contains(key)){
            return;
        }
        list.addLast(key);
    }

    public void remove(int key) {
        list.removeFirstOccurrence(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return list.contains(key);
    }

    public static void main(String[] args) {
        DesignHashSet705 solution = new DesignHashSet705();
        solution.add(1);
        solution.add(2);
        solution.contains(1);
        solution.contains(3);
        solution.add(2);
        solution.contains(2);
        solution.remove(2);
        solution.contains(2);
    }
}
