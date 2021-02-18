package com.lxj.algorithm.linearseach;

import com.lxj.algorithm.sort.SelectionSort;
import com.lxj.algorithm.sort.InsertionSort;

public class SortingHelper {
    public static <E extends Comparable<E>> boolean isSorted(E [] arr){
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1].compareTo(arr[i]) > 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 可以用反射
     * @param sortName
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sortTest(String sortName, E [] arr){
        long startTime = System.nanoTime();
        if (sortName.equals("SelectionSort")){
            SelectionSort.noExtraSpaceSort(arr);
        }else if(sortName.equals("InsertionSort")){
            InsertionSort.insertSort(arr);
        }else if(sortName.equals("InsertionSortImproved")){
            InsertionSort.insertSortImproved(arr);
        }
        long endTime = System.nanoTime();
        if (!SortingHelper.isSorted(arr)){
            throw new RuntimeException("");
        }
        System.out.println(sortName+", execution time is: " + (endTime - startTime) / 1000000000.0);
    }
}
