package com.lxj.leetcode.simulation;

import java.util.HashMap;

/**
 * @author Xingjing.Li
 * @since 2023/1/11
 */
public class CheckIfNumberHasEqualDigitCountAndDigitValue2283 {

    public boolean digitCount(String num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = num.length();
        for (int i = 0; i < n; i++) {
            int number = num.charAt(i) - '0';
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int time = num.charAt(i) - '0';
            if ( map.getOrDefault(i, 0)!= time){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIfNumberHasEqualDigitCountAndDigitValue2283 solution = new CheckIfNumberHasEqualDigitCountAndDigitValue2283();
        System.out.println(solution.digitCount("030"));
    }
}
