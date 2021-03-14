package com.lxj.leetcode.array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * @author lee
 */
public class SearchInsertPosition35 {

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

    public int searchInsertBinarySearch(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r){
            int mid = (l+r)/2;
            if (nums[mid] > target){
                r = mid - 1;
            }else if (nums[mid] < target){
                l = mid + 1;
            }else{
                return mid;
            }
        }
        return r+1;
    }

    public static void main(String[] args) {
        SearchInsertPosition35 solution = new SearchInsertPosition35();
        int [] nums = {1,3,5,6};
        solution.searchInsertBinarySearch(nums, 2);
    }
}
