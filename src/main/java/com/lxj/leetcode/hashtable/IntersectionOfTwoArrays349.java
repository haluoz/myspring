package com.lxj.leetcode.hashtable;

import java.util.HashSet;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 */
public class IntersectionOfTwoArrays349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            //set中包含重复元素添加到交集set中
            if (set.contains(nums2[i])){
                intersection.add(nums2[i]);
            }
        }
        //set转int数组
        int [] retArr = new int[intersection.size()];
        for (int num : intersection) {
            retArr[index++] = num;
        }
        return retArr;
    }

    public static void main(String[] args) {

    }
}
