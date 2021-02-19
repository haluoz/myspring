package com.lxj.algorithm.sort;

import com.lxj.algorithm.linearseach.ArrayGenerator;
import com.lxj.algorithm.linearseach.SortingHelper;

/**
 * 把最小的拿出
 * 再把最小的拿出
 * 再把最小的拿出
 * 不断重复
 */
public class SelectionSort {
    /**
     * 申请额外的空间
     * @param data
     * @return
     */
    public static int[] extraSpaceSort(int [] data){
        int[] extraArray = new int[data.length];
        int index =0;
        while (true){
            int min = data[0];
            for (int i = 0; i < data.length; i++) {
                if (min > data[i] && data[i] != 0){
                    min = data[i];
                }
            }
            for (int i = 0; i < data.length; i++) {
                if (min == data[i] ){
                    data[i] = 0;
                }
            }
            extraArray[index++] = min;
            min = 0;
            if (index >= data.length){
                break;
            }
        }
        return extraArray;
    }

    /**
     * 在int数组上直接操作
     * 不申请额外的空间
     * @param data
     * @return
     */
    public static <E extends Comparable<E>> void noExtraSpaceSort(E [] data){
        int n = data.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (data[j].compareTo(data[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(data, i, minIndex);
        }
    }

    private static <E> void swap(E [] data, int i, int j) {
       E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        Integer [] test = {6,3,2,5,1,4};
        SelectionSort.noExtraSpaceSort(test);
        for (int n :test){
            System.out.print(n+" ");
        }

        Integer[] testArr = ArrayGenerator.generateRandomArray(10000, 10000);
        SortingHelper.sortTest("SelectionSort",testArr);

//        for (int n: SelectionSort.extraSpaceSort(test) ) {
//            System.out.print(n+",");
//        }
//        Student [] students ={new Student("aaa",98),
//                            new Student("bbb",100),
//                            new Student("ccc",66)};
//        SelectionSort.noExtraSpaceSort(students);
//        for (Student s: students) {
//            System.out.println(s.toString());
//        }
    }
}
