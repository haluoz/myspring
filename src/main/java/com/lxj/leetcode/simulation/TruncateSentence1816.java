package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2021/12/10
 */
public class TruncateSentence1816 {

    public String truncateSentence(String s, int k) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < length && count < k ; i++) {
            char c = s.charAt(i);
            if (c == ' ') count++;
            if (count < k) sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TruncateSentence1816 solution = new TruncateSentence1816();
        System.out.println(solution.truncateSentence("What is the solution to this problem", 4));
    }
}
