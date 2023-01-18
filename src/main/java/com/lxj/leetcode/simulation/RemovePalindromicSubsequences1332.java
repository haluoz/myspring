package com.lxj.leetcode.simulation;

/**
 * 「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。
 * 「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。
 * @author Xingjing.Li
 * @since 2022/4/2
 */
public class RemovePalindromicSubsequences1332 {

    public int removePalindromeSub(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)) return 2;
            i++; j--;
        }
        return 1;
    }

    public static void main(String[] args) {
        RemovePalindromicSubsequences1332 solution = new RemovePalindromicSubsequences1332();
        solution.removePalindromeSub("abb");
    }
}
