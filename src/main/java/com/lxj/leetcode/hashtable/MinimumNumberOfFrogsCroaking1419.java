package com.lxj.leetcode.hashtable;

import java.util.HashMap;

/**
 * @author Xingjing.Li
 * @since 5/6/2023
 */
public class MinimumNumberOfFrogsCroaking1419 {
    // hints

    public int minNumberOfFrogs(String croakOfFrogs) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char c = croakOfFrogs.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return (map.get('c') + map.get('r') + map.get('o') + map.get('a') + map.get('k')) % 5 == 0 ? map.get('c') : -1;
    }

    public static void main(String[] args) {
        MinimumNumberOfFrogsCroaking1419 solution = new MinimumNumberOfFrogsCroaking1419();
        System.out.println(solution.minNumberOfFrogs("crcoakroak"));
    }
}
