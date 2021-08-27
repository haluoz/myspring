package com.lxj.leetcode.string;

/**
 * @author Xingjing.Li
 * @since 2021/8/23
 */
public class ReverseStringII541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i+=2*k){
            ReverseUtil.reverse(chars, i, Math.min(i+k, chars.length)-1);
        }
        String str = String.valueOf(chars);
        return str;
    }

    public static void main(String[] args) {
        ReverseStringII541 solution = new ReverseStringII541();
        System.out.println(solution.reverseStr("a",2));
    }
}
