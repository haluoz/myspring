package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2022/12/28
 */
public class MinimumLengthOfStringAfterDeletingSimilarEnds1750 {
    public int minimumLength(String s) {
        int i = 0, j = s.length()-1;
        while (i < j && s.charAt(i) == s.charAt(j)){
            char c = s.charAt(i);
            while (i<j && s.charAt(i) == c){
                i++;
            }
            while (i<=j && s.charAt(j) == c){
                j--;
            }
        }
        return j-i+1;
    }

    public static void main(String[] args) {
        MinimumLengthOfStringAfterDeletingSimilarEnds1750 solution = new MinimumLengthOfStringAfterDeletingSimilarEnds1750();
        System.out.println(solution.minimumLength("cabaabac"));
    }
}
