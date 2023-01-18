package com.lxj.leetcode.array;

import java.util.*;

/**
 * @author Xingjing.Li
 * @since 2022/4/1
 */
public class ArrayOfDoubledPairs954 {

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : arr) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        if (cnt.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }
        List<Integer> vals = new ArrayList<Integer>();
        for (int x : cnt.keySet()) {
            vals.add(x);
        }
        Collections.sort(vals, (a, b) -> Math.abs(a) - Math.abs(b));
        for (int x : vals) {
            if (cnt.getOrDefault(2 * x, 0) < cnt.get(x)) { // 无法找到足够的 2x 与 x 配对
                return false;
            }
            cnt.put(2 * x, cnt.getOrDefault(2 * x, 0) - cnt.get(x));
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayOfDoubledPairs954 solution = new ArrayOfDoubledPairs954();
        int[] ints = {4, -2, 2, -4};
        solution.canReorderDoubled(ints);
    }
}
