package com.lxj.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Xingjing.Li
 * @since 2021/8/23
 */
public class ReverseVowelsOfAString345 {

    static char[] vowels = new char[]{'a','e','i','o','u'};
    static Set<Character> set = new HashSet<>();
    static {
        for (char c : vowels) {
            set.add(c);
            set.add(Character.toUpperCase(c));
        }
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            if (set.contains(chars[l]) && set.contains(chars[r])) {
                ReverseUtil.reverse(chars, l++, r--);
            } else {
                if (!set.contains(chars[l])) l++;
                if (!set.contains(chars[r])) r--;
            }
        }
        return String.valueOf(chars);
    }


    public static void main(String[] args) {
        ReverseVowelsOfAString345 solution = new ReverseVowelsOfAString345();
        System.out.println(solution.reverseVowels("hello"));
    }
}
