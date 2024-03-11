package com.lxj.leetcode.simulation;

import java.util.HashSet;

/**
 * @author Xingjing.Li
 * @since 5/10/2023
 */
public class SmallestIntegerDivisibleByK1015 {
    public int smallestRepunitDivByK(int k) {
        int remainder = 1, length = 1;
        HashSet<Integer> set = new HashSet<>();
        set.add(remainder);
        while (remainder != 0) {
            remainder = (remainder * 10 + 1) % k;
            length++;
            if (set.contains(remainder)) {
                return -1;
            }
            set.add(remainder);
        }
        return length;
    }
    public static void main(String[] args) {
        SmallestIntegerDivisibleByK1015 solution = new SmallestIntegerDivisibleByK1015();
        System.out.println(solution.smallestRepunitDivByK(3));
    }
}
