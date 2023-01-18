package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2022/10/24
 */
public class PartitionArrayIntoDisjointIntervals915 {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int [] min = new int[n+10];
        // nums最后一个元素赋值
        min[n-1] = nums[n-1];
        //nums倒数第二个元素开始
        //min最后一个元素开始
        //nums和min开始找最小值
        for (int i = n-2; i >= 0; i--) {
            min[i] = Math.min(min[i+1], nums[i]);
        }
        //正向循环
        for (int i = 0, max = 0; i < n-1; i++) {
            max = Math.max(max, nums[i]);
            if (max <= min[i+1]) return i+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        PartitionArrayIntoDisjointIntervals915 solution = new PartitionArrayIntoDisjointIntervals915();
        int[] ints = {5, 0, 3, 8, 6};
        System.out.println(solution.partitionDisjoint(ints));
    }
}
