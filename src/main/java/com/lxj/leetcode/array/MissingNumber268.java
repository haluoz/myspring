package com.lxj.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Xingjing.Li
 * @since 2021/11/10
 */
public class MissingNumber268 {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i){
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        MissingNumber268 solution = new MissingNumber268();
        System.out.println(solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
