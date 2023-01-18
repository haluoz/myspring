package com.lxj.leetcode.simulation;

import java.util.Arrays;

/**
 * @author Xingjing.Li
 * @since 2023/1/9
 */
public class MinimumNumberOfOperationsToReinitializeAPermutation1806 {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
            target[i] = i;
        }
        int step = 0;
        while (true) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if ((i & 1) != 0) {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                } else {
                    arr[i] = perm[i / 2];
                }
            }
            perm = arr;
            step++;
            if (Arrays.equals(perm, target)) {
                break;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        MinimumNumberOfOperationsToReinitializeAPermutation1806 solution = new MinimumNumberOfOperationsToReinitializeAPermutation1806();
        System.out.println(solution.reinitializePermutation(4));
    }
}
