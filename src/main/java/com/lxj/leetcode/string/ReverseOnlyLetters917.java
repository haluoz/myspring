package com.lxj.leetcode.string;

/**
 * @author Xingjing.Li
 * @since 2022/2/23
 */
public class ReverseOnlyLetters917 {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0, j = n - 1; i < j; ) {
            while (i < j && !Character.isLetter(chars[i])) i++;
            while (i < j && !Character.isLetter(chars[j])) j--;
            if (i < j) {
                char c = chars[i];
                chars[i++] = chars[j];
                chars[j--] = c;
            }
        }
        return String.valueOf(chars);
    }

    public String reverseOnlyLetters1(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int i = 0, j = n-1;
        while (i<j){
            while (i<j && !Character.isLetter(chars[i])){
                i++;
            }
            while (i<j && !Character.isLetter(chars[j])){
                j--;
            }
            if (i < j) {
                char c = chars[i];
                chars[i++] = chars[j];
                chars[j--] = c;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        ReverseOnlyLetters917 solution = new ReverseOnlyLetters917();
        System.out.println(solution.reverseOnlyLetters1("7_28]"));
    }
}
