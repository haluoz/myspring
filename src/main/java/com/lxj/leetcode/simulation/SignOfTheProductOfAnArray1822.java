package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2022/10/27
 */
public class SignOfTheProductOfAnArray1822 {
    public int arraySign(int[] nums) {
        int ans = 1;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) ans *= -1;
        }
        return ans;
    }
}
