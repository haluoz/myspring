package com.lxj.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xingjing.Li
 * @since 2022/2/10
 */
public class SimplifiedFractions1447 {

    /**
     * 假如需要求 1997 和 615 两个正整数的最大公约数,用欧几里得算法，是这样进行的：
     * 1997 / 615 = 3 (余 152)
     * 615 / 152 = 4(余7)
     * 152 / 7 = 21(余5)
     * 7 / 5 = 1 (余2)
     * 5 / 2 = 2 (余1)
     * 2 / 1 = 2 (余0)
     * 至此，最大公约数为1
     * @param a 1997
     * @param b 615
     * @return 最大公约数
     */
    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a%b);
    }

    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) {
                    ans.add(i + "/" + j);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SimplifiedFractions1447 solution = new SimplifiedFractions1447();
        System.out.println(solution.simplifiedFractions(2));
    }
}
