package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2022/1/18
 */
public class CalculateMoneyInLeetcodeBank1716 {

    public int totalMoney(int n) {
        int a = n / 7, b = n % 7;
        int ans = 0, k = 1;
        while (a-- > 0) {
            //等差数列求和 数列和=(首项+末项)×项数÷2
            ans += (k + (k + 6)) * 7 / 2;
            k++;
        }
        while (b-- > 0) {
            ans += k++;
        }
        return ans;
    }

    public static void main(String[] args) {
        CalculateMoneyInLeetcodeBank1716 solution = new CalculateMoneyInLeetcodeBank1716();
        solution.totalMoney(15);
    }
}
