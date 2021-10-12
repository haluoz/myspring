package com.lxj.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] ints = {5, 7, 12, 3, 8, 33};
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length - 1 - i; j++) {
                if (ints[j] > ints[j+1]){
                    int temp = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(ints));
    }

    public static <E extends Comparable<E>> void sort(E [] data){
        for (int i = 0; i+1 < data.length; i++) {
            for (int j = 0; j < data.length - i -1; j++) {
                if (data[j].compareTo(data[j+1]) > 0){
                    swap(data, j, j+1);
                }
            }
        }
    }

    public static <E extends Comparable<E>> void sortImprove(E [] data){
        for (int i = 0; i+1 < data.length; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < data.length - i -1; j++) {
                if (data[j].compareTo(data[j+1]) > 0){
                    swap(data, j, j+1);
                    isSwapped = true;
                }
            }
            if (!isSwapped){
                break;
            }
        }
    }

    public static <E extends Comparable<E>> void sortAdvancedImprove(E [] data){
        for (int i = 0; i+1 < data.length;) {
            int lastSwapIndex = 0;
            for (int j = 0; j < data.length - i -1; j++) {
                if (data[j].compareTo(data[j+1]) > 0){
                    swap(data, j, j+1);
                    lastSwapIndex = j+1;
                }
            }
            //if (lastSwapIndex == 0){ break; }
            i = data.length - lastSwapIndex;
        }
    }

    private static <E extends Comparable<E>> void swap(E[] data, int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
