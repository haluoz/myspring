package com.lxj.algorithm.stack;

/**
 * @author Administrator
 */
public interface Stack<E> {
     void push(E val);

     E pop();

     E peek();

     int getSize();

     boolean isEmpty();
}
