package com.lxj.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xingjing.Li
 * @since 5/26/2023
 */
public class OddStringDifference2451 {
    public static void main(String[] args) {
        OddStringDifference2451 solution = new OddStringDifference2451();
        String[] strings = {"adc", "wzy", "abc"};
        solution.oddString(strings);

    }

    public String oddString(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i <= 25; i++) {
            map.put((char)('a'+i), i);
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int length = word.length();
            for (int j = 0; j < length; j++) {
                char c = word.charAt(j);
                Integer position = map.get(c);

            }
        }
        return "";
    }
}
