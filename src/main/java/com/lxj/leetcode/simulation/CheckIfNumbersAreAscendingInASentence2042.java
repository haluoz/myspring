package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2023/1/3
 */
public class CheckIfNumbersAreAscendingInASentence2042 {

    public boolean areNumbersAscending(String s) {
        String[] strings = s.split(" ");
        int prev = 0;
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            if (Character.isDigit(string.charAt(0))){
                int number = Integer.parseInt(string);
                if ( number <= prev){
                    return false;
                }
                prev = number;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "hello world 55 x 5";
        CheckIfNumbersAreAscendingInASentence2042 solution = new CheckIfNumbersAreAscendingInASentence2042();
        System.out.println(solution.areNumbersAscending(s));
    }
}
