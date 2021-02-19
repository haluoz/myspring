package com.lxj.algorithm.sort;

import com.lxj.algorithm.linearseach.SortingHelper;
import com.lxj.algorithm.linearseach.ArrayGenerator;

import java.util.Arrays;

public class InsertionSort {
    public static <E extends Comparable<E>> void insertSort(E [] data){
        for (int i = 0; i < data.length; i++) {
            for (int j = i; j-1>=0 ; j--) {
                if (data[j].compareTo(data[j-1])<0){
                    swap(data,j,j-1);
                }else {
                    break;
                }
            }
        }
    }

    public static <E extends Comparable<E>> void insertSortImproved(E [] data){
        for (int i = 0; i < data.length; i++) {
            E t = data[i];
            int j;
            for (j= i; j-1>=0 && t.compareTo(data[j-1]) < 0; j--) {
                data[j] = data[j-1];
            }
            data[j] = t;
        }
    }

    private static<E> void swap(E[] data, int j, int i) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] array = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(array, array.length);
//        Integer [] array = {6,4,1,5,2,3};
        SortingHelper.sortTest("InsertionSort", array);
        SortingHelper.sortTest("InsertionSortImproved", arr2);
    }
}
