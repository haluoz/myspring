package com.lxj.leetcode.simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xingjing.Li
 * @since 2022/3/31
 */
public class SelfDividingNumbers728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        out:for (int i = left; i <= right; i++) {
            int cur = i;
            while (cur != 0) {
                int t = cur % 10;
                if (t == 0 || i % t != 0) continue out;
                cur /= 10;
            }
            ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        SelfDividingNumbers728 solution = new SelfDividingNumbers728();
        System.out.println(solution.selfDividingNumbers(1, 22));
    }
}
