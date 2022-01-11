package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2022/1/7
 */
public class MaximumNestingDepthOfTheParentheses1614 {
    public int maxDepth(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0, cnt = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            }
            else if (s.charAt(i) == ')') {
                cnt--;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumNestingDepthOfTheParentheses1614 solution = new MaximumNestingDepthOfTheParentheses1614();
        System.out.println(solution.maxDepth("(1)+((2))+(((3)))"));
    }
}
