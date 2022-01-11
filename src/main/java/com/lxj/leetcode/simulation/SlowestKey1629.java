package com.lxj.leetcode.simulation;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author Xingjing.Li
 * @since 2022/1/10
 */
public class SlowestKey1629 {
    public char slowestKey1(int[] releaseTimes, String keysPressed) {
        int arrSize = releaseTimes.length, keySize = keysPressed.length(), index = 0;
        int maxPressedTime = releaseTimes[0];
        for (int i = 1; i < arrSize; i++) {
            int pressTime = releaseTimes[i] - releaseTimes[i-1];
            if (pressTime > maxPressedTime){
                maxPressedTime = pressTime;
                index = i;
            } else if (pressTime == maxPressedTime && keysPressed.charAt(i) > keysPressed.charAt(index)) {
                index = i;
            }
        }
        return keysPressed.charAt(index);
    }

    public char slowestKey(int[] releaseTimes, String keysPressed){
        int n = releaseTimes.length, idx = 0, max = releaseTimes[0];
        for (int i = 1; i < n; i++) {
            int cur = releaseTimes[i] - releaseTimes[i - 1];
            if (cur > max) {
                idx = i; max = cur;
            } else if (cur == max && keysPressed.charAt(i) > keysPressed.charAt(idx)) {
                idx = i;
            }
        }
        return keysPressed.charAt(idx);
    }

    public static void main(String[] args) {
        SlowestKey1629 solution = new SlowestKey1629();
        System.out.println(solution.slowestKey1(new int[]{9, 29, 49, 50}, "cbcd"));
    }
}
