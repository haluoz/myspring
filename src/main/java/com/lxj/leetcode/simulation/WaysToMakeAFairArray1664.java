package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2023/1/28
 */
public class WaysToMakeAFairArray1664 {
    public int waysToMakeFair(int[] nums) {
        int odd1 = 0, even1 = 0;
        int odd2 = 0, even2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if ((i & 1) != 0) {
                odd2 += nums[i];
            } else {
                even2 += nums[i];
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if ((i & 1) != 0) {
                odd2 -= nums[i];
            } else {
                even2 -= nums[i];
            }
            if (odd1 + even2 == odd2 + even1) {
                ++res;
            }
            if ((i & 1) != 0) {
                odd1 += nums[i];
            } else {
                even1 += nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        WaysToMakeAFairArray1664 solution = new WaysToMakeAFairArray1664();
        solution.waysToMakeFair(new int[]{2,1,6,4});
    }
}
