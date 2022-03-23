package com.lxj.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xingjing.Li
 * @since 2022/1/19
 */
public class ContainsDuplicateII219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            // 滑动窗口-移除数组相应坐标的位置
            if (i > k) set.remove(nums[i - k - 1]);
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII219 solution = new ContainsDuplicateII219();
//        solution.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2);
        solution.containsNearbyDuplicate(new int[]{1,0,1,1}, 1);
    }
}
