package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2021/12/17
 */
public class WaterBottles1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange){
            int exchange = numBottles / numExchange;
            int remaining = numBottles % numExchange;
            ans += exchange;
            numBottles = exchange + remaining;
        }
        return ans;
    }

    public static void main(String[] args) {
        WaterBottles1518 solution = new WaterBottles1518();
        System.out.println(solution.numWaterBottles(15, 4));
    }
}
