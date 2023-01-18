package com.lxj.leetcode.string;

/**
 * @author Xingjing.Li
 * @since 2022/4/8
 */
public class RotateString796 {

    public boolean rotateString(String s, String goal) {
        int m = s.length(), n = goal.length();
        if (m != n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (s.charAt((i + j) % n) != goal.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    public boolean rotateString1(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    public static void main(String[] args) {
        RotateString796 solution = new RotateString796();
        System.out.println(solution.rotateString1("abcde", "cdeab"));
    }
}
