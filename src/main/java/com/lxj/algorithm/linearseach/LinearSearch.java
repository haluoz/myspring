package com.lxj.algorithm.linearseach;

public class LinearSearch {

    public static int search(int [] data, int val){
        for (int i = 0; i < data.length; i++) {
            if (data[i] == val){
                return i;
            }
        }
        return -1;
    }

    public static <E> int search(E [] data, E val){
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(val)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] dataSize = {1000000, 10000000};
        for (int n:dataSize) {
            Integer[] data = ArrayGenerator.generateOrderArray(n);
            long startTime = System.nanoTime();
            System.out.println(LinearSearch.search(data, n));
            long endTime = System.nanoTime();
            System.out.println("execution time is: " + (endTime - startTime) / 1000000000.0);
        }

    }
}
