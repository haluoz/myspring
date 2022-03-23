package com.lxj.leetcode.binarysearch;

/**
 * @author Xingjing.Li
 * @since 2022/2/16
 */
public class SingleElementInASortedArray540 {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n -1;
        while (l < r){
            int mid = l + r >> 1;
            // 余数为0
            if (mid % 2 == 0) {
                //查询mid的下一位
                if (mid + 1 < n && nums[mid] == nums[mid + 1]) l = mid + 1;
                else r = mid;
            } else {
                //余数不为0 查询mid的前一位
                if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) l = mid + 1;
                else r = mid;
            }
        }
        return nums[r];
    }

    public static void main(String[] args) {
        SingleElementInASortedArray540 solution = new SingleElementInASortedArray540();
//        int[] ints = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] ints = {3,3,7,7,10,11,11};
        solution.singleNonDuplicate(ints);
    }
}
