package com.lxj.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xingjing.Li
 * @since 2021/10/26
 */
public class NextGreaterElementI496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        Deque<Integer> d = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = m - 1; i >= 0; i--) {
            int x = nums2[i];
            while (!d.isEmpty() && d.peekLast() <= x) d.pollLast();
            map.put(x, d.isEmpty() ? -1 : d.peekLast());
            d.addLast(x);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = map.get(nums1[i]);
        return ans;
    }

    public static void main(String[] args) {
        NextGreaterElementI496 solution = new NextGreaterElementI496();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1,3,4,2};
        solution.nextGreaterElement(nums1, nums2);
    }
}
