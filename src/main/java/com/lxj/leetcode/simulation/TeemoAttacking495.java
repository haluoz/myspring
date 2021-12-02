package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2021/11/23
 */
public class TeemoAttacking495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0, last = -1;
        for (int s : timeSeries) {
            int e = s + duration - 1;
            ans += last < s ? duration : e - last;
            last = e;
        }
        return ans;
    }

    public static void main(String[] args) {
        TeemoAttacking495 solution = new TeemoAttacking495();
        System.out.println(solution.findPoisonedDuration(new int[]{1, 4}, 2));
    }
}
