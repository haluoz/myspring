package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2023/1/18
 */
public class DifferenceBetweenElementSumAndDigitSumOfAnArray2535 {

    public int differenceOfSum(int[] nums) {
        int sum = 0, digitSum = 0;
        for (int num : nums) {
            sum += num;
            int temp = num;
            while (temp>0){
                digitSum += temp % 10;
                temp /= 10;
            }
        }
        return Math.abs(sum-digitSum);
    }

    public static void main(String[] args) {
        DifferenceBetweenElementSumAndDigitSumOfAnArray2535 solution = new DifferenceBetweenElementSumAndDigitSumOfAnArray2535();
        solution.differenceOfSum(new int[]{1,15,6,3});
    }
}
