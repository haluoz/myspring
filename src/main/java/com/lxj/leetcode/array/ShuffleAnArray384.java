package com.lxj.leetcode.array;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Xingjing.Li
 * @since 2021/11/22
 */
public class ShuffleAnArray384 {
    private int[] origin;
    private int length;
    Random random = new Random();
    public ShuffleAnArray384(int[] nums) {
        origin = nums;
        length = nums.length;
    }

    public int[] reset() {
        return origin;
    }

    public int[] shuffle() {
        int[] clone = origin.clone();
        for (int i = 0; i < length; i++) {
            swap(clone,i,random.nextInt(length - i));
        }
        return clone;
    }

    public void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        ShuffleAnArray384 solution = new ShuffleAnArray384(new int[]{1,2,3});
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }
}
