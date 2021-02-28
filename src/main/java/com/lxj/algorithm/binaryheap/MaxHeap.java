package com.lxj.algorithm.binaryheap;

import com.lxj.algorithm.array.Array;
import com.lxj.algorithm.linearseach.SortingHelper;
import com.lxj.algorithm.sort.*;

import java.util.Random;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array(capacity);
    }

    public MaxHeap(){
        data = new Array();
    }

    // 把一个不符合要求的堆转换成符合要求的堆Heapify
    public MaxHeap(E [] arr) {
        data = new Array<E>(arr);
        for (int i = parent(arr.length-1); i >=0 ; i--) {
            siftDown(i);
        }
    }

    //添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }

    private void siftUp(int index) {
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index))< 0){
            data.swap(index, parent(index));
            index = parent(index);
        }
    }

    public E extractMax(){
        E ret = findMax();
        data.swap(0, data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int index) {
        while (leftChild(index) < data.getSize() ){
            int j = leftChild(index);
            if (j+1 < data.getSize() && data.get(j+1).compareTo(data.get(j)) > 0){
                j = rightChild(index);
            }
            if (data.get(index).compareTo(data.get(j)) >= 0){
                break;
            }
            data.swap(index,j);
            index = j;
        }
    }

    public E findMax(){
        if (data.getSize() == 0){
            throw new IllegalArgumentException("heap is empty");
        }
        return data.get(0);
    }

    public E replace(E e){
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素父亲节点的索引
    private int parent(int index){
        if (index == 0){
            throw new IllegalArgumentException("index 0 do not have parent");
        }
        return (index-1)/2;
    }

    private int leftChild(int index){
        return index * 2 + 1;
    }

    private int rightChild(int index){
        return index * 2 + 2;
    }

    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> heap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = heap.extractMax();
        }
        for (int i = 1; i < n; i++) {
//            System.out.println(arr[i]);
            if(arr[i-1] < arr[i]){
                throw new RuntimeException("ERROR");
            }
        }
        System.out.println("Success");

//        int [] arr = {62,52,30,28,41,22,13,19,17,15};
//        for (int i = 0; i < arr.length; i++) {
//            heap.add(arr[i]);
//        }
//        heap.add(16);
//        heap.extractMax();
    }
}
