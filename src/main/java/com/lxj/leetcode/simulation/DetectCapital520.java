package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2021/11/17
 */
public class DetectCapital520 {
    public boolean detectCapitalUse(String word) {
        if (word.toUpperCase().equals(word)) return true;
        if (word.toLowerCase().equals(word)) return true;
        int length = word.length(), index = 1;
        if (Character.isUpperCase(word.charAt(0))){
            for (int i = 1; i < length; i++) {
                if (Character.isLowerCase(word.charAt(i))) index++;
            }
        }
        return length == index;
    }

    public static void main(String[] args) {
        DetectCapital520 solution = new DetectCapital520();
        solution.detectCapitalUse("Google");
    }
}
