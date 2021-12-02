package com.lxj.algorithm.binarysearch;

/**
 * 用二分查找需要有序的数组
 * 二分查找应用于多次查找
 */
public class BinarySearch {
    public static <E extends Comparable<E>> int searchRecursion(E [] data, E target){
        return search(data,0, data.length, target);
    }

    //二分查找递归
    private static <E extends Comparable<E>> int search(E [] data, int l, int r, E target){
        if (l>r){
            return -1;
        }
        int mid = l + (r-l)/2;
        if (data[mid].compareTo(target) == 0){
            return mid;
        }
        if (data[mid].compareTo(target) > 0){
            return search(data, l, mid-1, target);
        }
        if (data[mid].compareTo(target) < 0){
            return search(data, mid+1, r, target);
        }
        return -1;
    }

    //二分查找循环
    public static <E extends Comparable<E>> int search(E [] data, E target){
        int l = 0, r = data.length - 1;
        // data[l ,r]范围中查找target
        while (l <= r){
            int mid = l + (r-l)/2;
            if (data[mid].compareTo(target) == 0){
                return mid;
            }
            if (data[mid].compareTo(target) < 0){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] array = {-1,0,3,5,9,12,15};
        System.out.println(searchRecursion(array, 2));
        search(array, 15);
    }
}
