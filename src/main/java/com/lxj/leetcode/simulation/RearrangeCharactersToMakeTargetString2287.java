package com.lxj.leetcode.simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xingjing.Li
 * @since 2023/1/13
 */
public class RearrangeCharactersToMakeTargetString2287 {

    public int rearrangeCharacters(String s, String target) {
        Integer ans = Integer.MAX_VALUE;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int length = target.length();
        for (int i = 0; i < length; i++) {
            char c = target.charAt(i);
            targetMap.put(c, targetMap.getOrDefault(c, 0)+1);
        }
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            Character key = entry.getKey();
            Integer times = map.getOrDefault(key, 0);
            ans = Math.min(ans, times/entry.getValue());
        }
        return ans;
    }

    public static void main(String[] args) {
        RearrangeCharactersToMakeTargetString2287 solution = new RearrangeCharactersToMakeTargetString2287();
        System.out.println(solution.rearrangeCharacters("abbaccaddaeea", "aaaaa"));
    }
}
