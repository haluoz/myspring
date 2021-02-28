package com.lxj.algorithm;

import com.lxj.algorithm.array.Array;
import com.lxj.algorithm.binaryheap.MaxHeap;
import com.lxj.algorithm.queue.ArrayQueue;
import com.lxj.algorithm.stack.ArrayStack;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Array arr = new Array<Integer>();
        arr.addFirst(1);
        for (int i = 2; i < 10; i++) {
            arr.addLast(i);
        }
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

    public static <E extends Comparable<E>> void testHeap(Integer [] testData, boolean isHeapify){
        MaxHeap<Integer> heap;
        long startTime = System.nanoTime();
        if (isHeapify){
            heap = new MaxHeap<>(testData);
        }else {
            heap = new MaxHeap<>();
            for (int i = 0; i < testData.length; i++) {
                heap.add(testData[i]);
            }
        }
        long endTime = System.nanoTime();
        System.out.println("execution time is: " + (endTime - startTime) / 1000000000.0);
        Integer [] arr = new Integer[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = heap.extractMax();
        }
        for (int i = 1; i < testData.length; i++) {
//            System.out.println(arr[i]);
            if(arr[i-1] < arr[i]){
                throw new RuntimeException("ERROR");
            }
        }
        System.out.println("Success");
    }
}
