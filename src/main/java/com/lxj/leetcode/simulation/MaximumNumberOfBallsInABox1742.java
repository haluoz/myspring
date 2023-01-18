package com.lxj.leetcode.simulation;

import java.util.HashMap;

/**
 * @author Xingjing.Li
 * @since 2022/11/23
 */
public class MaximumNumberOfBallsInABox1742 {
    public int countBalls1(int lowLimit, int highLimit) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int box =0, x = i;
            while (x != 0){
                box += x % 10;
                x /= 10;
            }
            map.put(box, map.getOrDefault(box, 0)+1);
            ans = Math.max(ans, map.get(box));
        }
        return ans;
    }

    public int countBalls(int lowLimit, int highLimit) {
        int ans = 0;
        int [] record = new int[50];
        for (int i = lowLimit; i <= highLimit; i++) {
            int box =0, x = i;
            while (x != 0){
                box += x % 10;
                x /= 10;
            }
            record[box] = ++record[box];
            ans = Math.max(ans, record[box]);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumNumberOfBallsInABox1742 solution = new MaximumNumberOfBallsInABox1742();
        System.out.println(solution.countBalls(1, 10));
        System.out.println(solution.countBalls1(1, 10));
    }
}
