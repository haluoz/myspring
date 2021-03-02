package com.lxj.algorithm.sort;

import com.lxj.algorithm.linearseach.ArrayGenerator;
import com.lxj.algorithm.linearseach.SortingHelper;

public class ShellsSort {
    public static <E extends Comparable<E>> void sort(E [] data) {
        int h = data.length / 2;
        while (h >= 1){
            for (int start = 0; start < h; start++) {
                //对data[start,start+h,start+2h,start+3h...]进行插入排序
                for (int i = start+h; i < data.length; i+=h) {
                    E temp = data[i];
                    int j;
                    for ( j = i; j -h>=0 && temp.compareTo(data[j-h]) < 0; j-=h) {
                        data[j] = data[j-h];
                    }
                    data[j] = temp;
                }
            }
            h /= 2;
        }
    }

    //代码优化减少for循环
    public static <E extends Comparable<E>> void sortImproved(E [] data) {
        int h = data.length / 2;
        while (h >= 1){
            for (int i = h; i < data.length; i++) {
                E temp = data[i];
                int j;
                for ( j = i; j -h>=0 && temp.compareTo(data[j-h]) < 0; j-=h) {
                    data[j] = data[j-h];
                }
                data[j] = temp;
            }
            h /= 2;
        }
    }

    //步长序列
    public static <E extends Comparable<E>> void sortAdvancedImproved(E [] data) {
        int h = 1;
        while (h < data.length){
            h = h * 3 + 1;
        }
        while (h >= 1){
            for (int i = h; i < data.length; i++) {
                E temp = data[i];
                int j;
                for ( j = i; j -h>=0 && temp.compareTo(data[j-h]) < 0; j-=h) {
                    data[j] = data[j-h];
                }
                data[j] = temp;
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] array = ArrayGenerator.generateRandomArray(n, n);
        Integer[] array2 = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("ShellsSort",array);
        SortingHelper.sortTest("MergeSort",array2);
    }
}
