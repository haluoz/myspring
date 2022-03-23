package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2022/3/1
 */
public class MaximumDifferenceBetweenIncreasingElements2016 {
    public int maximumDifference(int[] nums) {
        int n = nums.length, ans = -1;
//        for (int i = 0, min = nums[0]; i < n; i++) {
//            if (nums[i] > min) ans = Math.max(ans, nums[i] - min);
//            min = Math.min(min, nums[i]);
//        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums[i] < nums[j]){
                    ans = Math.max(ans, nums[j] - nums[i]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumDifferenceBetweenIncreasingElements2016 solution = new MaximumDifferenceBetweenIncreasingElements2016();
        int [] ints = {7,1,5,4};
        System.out.println(solution.maximumDifference(ints));
    }
}
