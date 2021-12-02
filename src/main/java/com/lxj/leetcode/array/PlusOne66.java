package com.lxj.leetcode.array;

import java.util.ArrayList;

/**
 * @author Xingjing.Li
 * @since 2021/10/21
 */
public class PlusOne66 {
    public int[] plusOne(int[] digits) {
        int bit = 0;
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--){
            if (digits[i] == 9){
                digits[i] = 0;
            }else{
                digits[i]++;
                return digits;
            }
        }
        int [] newInt = new int[n+1];
        newInt[0] = 1;
        return newInt;
    }

    public static void main(String[] args) {
        PlusOne66 solution = new PlusOne66();
        solution.plusOne(new int[]{9,9});
    }
}
