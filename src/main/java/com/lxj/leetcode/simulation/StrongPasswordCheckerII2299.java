package com.lxj.leetcode.simulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Xingjing.Li
 * @since 2023/1/19
 */
public class StrongPasswordCheckerII2299 {

    public boolean strongPasswordCheckerII(String password) {
        int n = password.length();
        if (n < 8) return false;
        boolean isUpperCase = false, isLowerCase = false, isDigit = false,
                isSpecialCharacter = false, sameCharacter = true;
        HashSet<Character> set = new HashSet<>();
        set.add('!');
        set.add('@');
        set.add('#');
        set.add('$');
        set.add('%');
        set.add('^');
        set.add('&');
        set.add('*');
        set.add('(');
        set.add(')');
        set.add('-');
        set.add('+');
        Character prevChar = null;
        for (int i = 0; i < n; i++) {
            char c = password.charAt(i);
            if (prevChar != null && prevChar == c){
                sameCharacter = false;
            }else if (Character.isLowerCase(c)){
                isLowerCase = true;
            }else if (Character.isUpperCase(c)){
                isUpperCase = true;
            } else if (Character.isDigit(c)) {
                isDigit = true;
            } else if (set.contains(c)) {
                isSpecialCharacter = true;
            }
            prevChar = c;
        }
        return isUpperCase && isLowerCase && isDigit && isSpecialCharacter && sameCharacter;
    }

    public static void main(String[] args) {
        StrongPasswordCheckerII2299 solution = new StrongPasswordCheckerII2299();
        System.out.println(solution.strongPasswordCheckerII("11A!A!Aa"));
    }
}
