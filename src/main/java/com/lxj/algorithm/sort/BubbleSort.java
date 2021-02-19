package com.lxj.algorithm.sort;

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
        System.out.println(ints);
    }
}
