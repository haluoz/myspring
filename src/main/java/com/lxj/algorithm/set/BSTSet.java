package com.lxj.algorithm.set;

import com.lxj.algorithm.bst.BinarySearchTree;

/**
 * @author Administrator
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BinarySearchTree<E> bst;

    public BSTSet() {
        bst = new BinarySearchTree<>();
    }

    @Override
    public void add(E e) {
        bst.addRecursion(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    public static void main(String[] args) {
        BSTSet<String> set = new BSTSet<>();
        String [] words = {"I","am","a","student","I","was","born","in","gz","I","love","here","It","would","be","great"};
        System.out.println(words.length);
        for (String word : words) {
            set.add(word);
        }
        System.out.println(set.getSize());
    }
}
