package com.lxj.leetcode.simulation;

import lombok.With;

/**
 * @author Xingjing.Li
 * @since 2023/1/9
 */
public class CountIntegersWithEvenDigitSum2180 {

    public int countEven(int num) {
        int ans = 0;
        for (int i = 1; i <= num; i++) {
            int sum = 0, x = i;
            while (x != 0){
                sum += x % 10;
                x /= 10;
            }
            if (sum % 2 ==0){
               ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountIntegersWithEvenDigitSum2180 solution = new CountIntegersWithEvenDigitSum2180();
        System.out.println(solution.countEven(30));
    }
}
