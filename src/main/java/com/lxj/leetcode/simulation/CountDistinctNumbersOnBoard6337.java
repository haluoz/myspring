package com.lxj.leetcode.simulation;

import java.util.HashSet;

/**
 * @author Xingjing.Li
 * @since 2023/1/29
 */
public class CountDistinctNumbersOnBoard6337 {

    public int distinctIntegers(int n) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = n; i > 0; i--) {
            for (int j = n; j > 0; j--) {
                if (i % j == 1) {
                    set.add(j);
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        CountDistinctNumbersOnBoard6337 solution = new CountDistinctNumbersOnBoard6337();
        System.out.println(solution.distinctIntegers(3));
    }
}
