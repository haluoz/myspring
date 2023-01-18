package com.lxj.leetcode.simulation;

import com.lxj.leetcode.string.CheckIfOneStringSwapCanMakeStringsEqual1790;

/**
 * @author Xingjing.Li
 * @since 2022/11/28
 */
public class CheckIfArrayIsSortedAndRotated1752 {

    public boolean check(int[] nums) {
        int n = nums.length, cnt = 0;
        for (int i = 0, cur = 110; i < n; ) {
            int j = i;
            while (j + 1 < n && nums[j] <= nums[j + 1]) {
                if (nums[j++] > cur) return false;
            }
            if (nums[j] > cur) return false;
            cur = Math.min(cur, nums[i]);
            i = j + 1; cnt++;
        }
        return cnt <= 2;
    }

    public static void main(String[] args) {
        CheckIfArrayIsSortedAndRotated1752 solution = new CheckIfArrayIsSortedAndRotated1752();
        solution.check(new int[]{3,4,5,1,2});
    }
}
