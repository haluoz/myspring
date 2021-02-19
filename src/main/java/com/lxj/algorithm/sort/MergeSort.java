package com.lxj.algorithm.sort;

import com.lxj.algorithm.linearseach.ArrayGenerator;
import com.lxj.algorithm.linearseach.SortingHelper;

import java.util.Arrays;

/**
 * 无法原地排序需要额外的空间
 */
public class MergeSort {

    public static <E extends Comparable<E>> void sort(E[] arr){
        sort(arr,0, arr.length-1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l,  int r){
        if (l>=r){
            return;
        }
        int mid = l+ (r-l)/2;
//        int mid =(l+r)/2;
        sort(arr,l, mid);
        sort(arr,mid+1, r);
        merge(arr,l,mid,r);
    }

    //合并两个有序的区间arr[l,mid] arr[mid+1, r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        E [] temp = Arrays.copyOfRange(arr, l, r+1);
        int i =l, j = mid + 1;
        //每轮循环为arr[k]赋值
        for (int k = l; k <= r; k++) {
            if (i>mid){
                arr[k] = temp[j-l];
                j++;
            }else if (j>r){
                arr[k] = temp[i-l];
                i++;
            }else if(temp[i-l].compareTo(temp[j-l]) <= 0){
                arr[k] = temp[i-l];
                i++;
            }else {
                arr[k] = temp[j-l];
                j++;
            }
            //arr[i] 和 arr[j]
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] array = ArrayGenerator.generateRandomArray(n,n);
        SortingHelper.sortTest("MergeSort", array);
    }
}
