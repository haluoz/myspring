package com.lxj.algorithm.sort;

import com.lxj.algorithm.linearseach.ArrayGenerator;
import com.lxj.algorithm.linearseach.SortingHelper;

import java.util.Random;

public class QuickSort {
    public static <E extends Comparable<E>> void sort(E [] arr){
        sort(arr, 0, arr.length-1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r){
        if (l>=r){
            return;
        }
        int partition = partition(arr, l, r);
        sort(arr, l, partition-1);
        sort(arr,partition+1, r);
    }

    private static <E extends Comparable<E>> int partition(E [] arr, int l, int r){
        //随机选择分标定点，而不是第一个作为标定点
        int p = l+(new Random().nextInt(r-l+1));
        swap(arr, l, p);
        //arr[l+1...j] < v and arr[j+1...j] => v
        int j = l;
        for (int i = l+1; i <= r ; i++) {
            if (arr[i].compareTo(arr[l]) < 0){
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static<E> void swap(E[] data, int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] array = ArrayGenerator.generateRandomArray(n,n);
        Integer [] arr = {5,3,7,1,8,4,6};
        //Integer[] array2 = Arrays.copyOf(array, array.length);
        SortingHelper.sortTest("QuickSort", arr);
        //SortingHelper.sortTest("MergeSort", array2);
    }
}
