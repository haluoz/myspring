package com.lxj.leetcode.binarysearch;

/**
 * @author Xingjing.Li
 * @since 2021/11/4
 */
public class ValidPerfectSquare367 {

    public boolean isPerfectSquare(int num) {
        Long l = 0L, r = (long) num;
        while (l < r){
            Long mid = (l + r) >> 1;
            if (mid * mid == num) {
                return true;
            }else if(mid*mid > num){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return r * r == num;
    }

    public static void main(String[] args) {
        ValidPerfectSquare367 solution = new ValidPerfectSquare367();
        solution.isPerfectSquare(2147483647);
    }
}
