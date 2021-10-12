package com.lxj.leetcode.string;

/**
 * @author Xingjing.Li
 * @since 2021/9/30
 */
public class SplitAStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int ans = 0;
        for (int i = 0; i < n; ) {
            int j = i + 1, score = cs[i] == 'L' ? 1 : -1;
            //逐个字符循环相加结果，直到score不为0
            while (j < n && score != 0)  {
                score += cs[j++] == 'L' ? 1 : -1;
            }
            i = j;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        SplitAStringInBalancedStrings solution = new SplitAStringInBalancedStrings();
        System.out.println(solution.balancedStringSplit("RLRRLLRLRL"));
    }
}
