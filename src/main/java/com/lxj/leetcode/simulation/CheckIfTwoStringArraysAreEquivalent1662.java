package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2022/11/1
 */
public class CheckIfTwoStringArraysAreEquivalent1662 {

//    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
//        StringBuilder sb1 = new StringBuilder();
//        StringBuilder sb2 = new StringBuilder();
//        for (String s : word1) {
//            sb1.append(s);
//        }
//        for (String s : word2) {
//            sb2.append(s);
//        }
//        return sb1.toString().equals(sb2.toString());
//    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int n = word1.length, m = word2.length;
        int i = 0, j = 0, p = 0, q = 0;
        while (i < n && j < m) {
            if (word1[i].charAt(p++) != word2[j].charAt(q++)) return false;
            if (p == word1[i].length()) {
                i++; p = 0;
            }
            if (q == word2[j].length()) {
                j++; q = 0;
            }
        }
        return i == n && j == m;
    }

    public static void main(String[] args) {
        CheckIfTwoStringArraysAreEquivalent1662 solution = new CheckIfTwoStringArraysAreEquivalent1662();
        String[] strings1 = {"ab", "c"};
        String[] strings2 = {"a", "bc"};
        System.out.println(solution.arrayStringsAreEqual(strings1, strings2));
    }
}
