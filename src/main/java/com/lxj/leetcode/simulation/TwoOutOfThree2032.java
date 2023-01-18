package com.lxj.leetcode.simulation;

import java.util.*;

/**
 * @author Xingjing.Li
 * @since 2022/12/29
 */
public class TwoOutOfThree2032 {
    public List<Integer> twoOutOfThree1(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums1) {
            map.put(i, 1);
        }
        for (int i : nums2) {
            map.put(i, map.getOrDefault(i, 0) | 2);
        }
        for (int i : nums3) {
            map.put(i, map.getOrDefault(i, 0) | 4);
        }
        List<Integer> res = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            if ((v & (v - 1)) != 0) {
                res.add(k);
            }
        }
        return res;
    }

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] h = new int[101];
        add(h, nums1);
        add(h, nums2);
        add(h, nums3);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < h.length; i++) {
            if (h[i] > 1) {
                ans.add(i);
            }
        }
        return ans;
    }

    private void add(int[] h, int[] nums1) {
        boolean[] m = new boolean[101];
        for (int n : nums1) {
            if (!m[n]) {
                m[n] = true;
                h[n]++;
            }
        }
    }

    public static void main(String[] args) {
        TwoOutOfThree2032 solution = new TwoOutOfThree2032();
        int[] nums1 = {1,1,3,2};
        int[] nums2 = {2,3};
        int[] nums3 = {3};
        solution.twoOutOfThree(nums1,nums2,nums3);
    }
}
