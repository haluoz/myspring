package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2022/2/9
 */
public class CountNumberOfPairsWithAbsoluteDifferenceK2006 {
    public int countKDifference(int[] nums, int k) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountNumberOfPairsWithAbsoluteDifferenceK2006 solution = new CountNumberOfPairsWithAbsoluteDifferenceK2006();
        int[] nums = {3,2,1,5,4};
        solution.countKDifference(nums,2);
    }
}
