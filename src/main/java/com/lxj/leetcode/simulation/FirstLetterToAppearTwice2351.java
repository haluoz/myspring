package com.lxj.leetcode.simulation;

import java.util.HashMap;

/**
 * @author Xingjing.Li
 * @since 2023/1/3
 */
public class FirstLetterToAppearTwice2351 {

    public char repeatedCharacter(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
            Integer times = map.get(c);
            if (times == 2){
                return c;
            }
        }
        return 'a';
    }

    public static void main(String[] args) {
        FirstLetterToAppearTwice2351 solution = new FirstLetterToAppearTwice2351();
        System.out.println(solution.repeatedCharacter("abccbaacz"));
    }
}
