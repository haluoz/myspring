package com.lxj.leetcode.array;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class MinimumSizeSubarraySum209 {

    // 暴力
    // i = 0 -> 2+3+1+2 >= 7 length = 4
    // i = 1 -> 3+1+2+4 >= 7 length = 4
    // i = 2 -> 1+2+4 >= 7 length = 3
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE; // 最终的结果
        int sum = 0; // 子序列的数值之和
        int subLength = 0; // 子序列的长度
        for (int i = 0; i < nums.length; i++) { // 设置子序列起点为i
            sum = 0;
            for (int j = i; j < nums.length; j++) { // 设置子序列起点为j
                sum += nums[j];
                if (sum >= target){ // 一旦发现子序列和超过了target，更新result
                    subLength = j - i + 1; // 取子序列的长度
                    result = result < subLength ? result : subLength; // 比较旧的子序列长度和新的子序列长度
                    break; // 因为我们是找符合条件最短的子序列，所以一旦符合条件就break
                }
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    // 滑动窗口
    int minSubArrayLen(int target, int[] nums,String slidingWindow) {
        int result = Integer.MAX_VALUE;
        int sum = 0; // 滑动窗口数值之和
        int i = 0; // 滑动窗口起始位置
        int subLength = 0; // 滑动窗口的长度
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            // 注意这里使用while，每次更新 i（起始位置），并不断比较子序列是否符合条件
            while (sum >= target) {
                subLength = (j - i + 1); // 取子序列的长度
                result = result < subLength ? result : subLength;
                sum -= nums[i++]; // 这里体现出滑动窗口的精髓之处，不断变更i（子序列的起始位置）
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum209 solution = new MinimumSizeSubarraySum209();
        int [] nums = {2,3,1,2,4,3};
        System.out.println(solution.minSubArrayLen(7, nums, ""));
    }
}
