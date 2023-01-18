package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2022/12/27
 */
public class MinimumMovesToConvertString2027 {

    public int minimumMoves(String s) {
        int count = 0;
        int n = s.length();
//        for (int i = 0, j = 0; i < n; i++) {
//            j = i;
//            if (s.charAt(j) == 'X'){
//                j++;
//            }
//
//        }
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == 'X') {
                ++count;
                i += 2;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        MinimumMovesToConvertString2027 solution = new MinimumMovesToConvertString2027();
        System.out.println(solution.minimumMoves("XXOXOX"));
//        System.out.println(solution.minimumMoves("OOOXOOOXO"));
    }
}
