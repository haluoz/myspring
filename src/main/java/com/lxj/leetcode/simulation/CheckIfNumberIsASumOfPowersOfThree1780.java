package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2022/12/9
 */
public class CheckIfNumberIsASumOfPowersOfThree1780 {

    public boolean checkPowersOfThree(int n) {
        while (n != 0){
            if (n % 3 == 1 || n % 3 == 0){
                n /= 3;
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIfNumberIsASumOfPowersOfThree1780 solution = new CheckIfNumberIsASumOfPowersOfThree1780();
        solution.checkPowersOfThree(12);
    }
}
