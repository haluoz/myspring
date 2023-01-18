package com.lxj.leetcode.simulation;

import java.util.TreeSet;

/**
 * @author Xingjing.Li
 * @since 2022/12/6
 */
public class SecondLargestDigitInAString1796 {

    public int secondHighest(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(chars[i])){
                set.add(Integer.parseInt(String.valueOf(chars[i])));
            }
        }
        if (set.size() <2 ) return -1;
        set.pollLast();
        return set.pollLast();
    }

    public int secondHighest1(String s) {
        int first = -1, second = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                if (num > first) {
                    second = first;
                    first = num;
                } else if (num < first && num > second) {
                    second = num;
                }
            }
        }
        return second;
    }

    public static void main(String[] args) {
        SecondLargestDigitInAString1796 solution = new SecondLargestDigitInAString1796();
        System.out.println(solution.secondHighest1("dfa12321afd"));
    }
}
