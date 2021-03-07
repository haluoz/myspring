package com.lxj.algorithm;

import java.util.*;

public class LeetCodeTest {
    public static int[] shuffle(int[] nums, int n) {
        int [] x = new int[n];
        int [] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nums[i];
        }
        for (int i = n,j=0; i < nums.length; i++) {
            y[j] = nums[i];
            j++;
        }
        int [] z = new int[nums.length];
        for (int i = 0, j = 0; i < n; i++) {
            z[j] = x[i];
            z[j+1] = y[i];
            j+=2;
        }
        return z;
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = findNextBigger(nums, i);
        }
        return ans;
    }

    private static int findNextBigger(int[] nums, int index) {
        int num = nums[index];
        int n = nums.length;
        for (int i = (index + 1) % n; i != index; i = (i + 1) % n) {
            if (nums[i] > num) {
                return nums[i];
            }
        }
        return -1;
    }


    public static void main(String[] args) {
//        int [] nums = {2,5,1,3,4,7};
//        int n = 3;
//        shuffle(nums, n);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(2);
        queue.add(5);
        queue.add(1);
        queue.add(6);
        new ArrayDeque<>();
//        int [] nums = {1,2,1};
//        int[] ints = nextGreaterElements(nums);
    }
}
