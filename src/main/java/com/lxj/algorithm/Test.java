package com.lxj.algorithm;

import com.lxj.algorithm.array.Array;
import com.lxj.algorithm.queue.ArrayQueue;
import com.lxj.algorithm.stack.ArrayStack;

public class Test {
    public static void main(String[] args) {
//        Array arr = new Array<Integer>();
//        arr.addFirst(1);
//        for (int i = 2; i < 10; i++) {
//            arr.addLast(i);
//        }
//        arr.add(1, 50);
//        System.out.println(arr.toString());
//        arr.addLast(20);
//        arr.addLast(21);
//        System.out.println(arr.toString());
//        arr.removeElement(20);
//        arr.removeElement(21);
//        arr.removeElement(8);
//        System.out.println(arr.toString());
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue.toString());
        }
        queue.dequeue();
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
    }
}
