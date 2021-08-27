package com.lxj.leetcode.string;

/**
 * @author Xingjing.Li
 * @since 2021/8/23
 */
public class ReverseUtil {
    public static void reverse(char[] chars, int left, int right){
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }
}
