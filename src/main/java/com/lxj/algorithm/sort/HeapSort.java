package com.lxj.algorithm.sort;

import com.lxj.algorithm.Test;
import com.lxj.algorithm.binaryheap.MaxHeap;
import com.lxj.algorithm.linearseach.ArrayGenerator;
import com.lxj.algorithm.linearseach.SortingHelper;

import java.util.Arrays;

public class HeapSort<E> {
    public static <E extends Comparable<E>> void sort(E [] data){
        MaxHeap<E> heap = new MaxHeap<>();
        for (E e: data) {
            heap.add(e);
        }
        for (int i = data.length-1; i >=0 ; i--) {
            data[i] = heap.extractMax();
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = ArrayGenerator.generateRandomArray(n, n);
//        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
//        Integer[] arr4 = Arrays.copyOf(arr, arr.length);
//        SortingHelper.sortTest("MergeSort", arr);
//        SortingHelper.sortTest("QuickSort", arr2);
//        SortingHelper.sortTest("HeapSort", arr3);
//        SortingHelper.sortTest("InsertionSort", arr4);
        Test.testHeap(arr, false);
        Test.testHeap(arr2,true);
    }
}
