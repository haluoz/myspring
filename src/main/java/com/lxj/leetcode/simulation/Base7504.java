package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2022/3/7
 */
public class Base7504 {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) return "0";
        boolean contains = String.valueOf(num).contains("-");
        if (contains){
            num = Math.abs(num);
        }
        while (num > 0){
            sb.append( num % 7);
            num = num / 7;
        }
        if (contains){
            sb.append("-");
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        Base7504 solution = new Base7504();
        System.out.println(solution.convertToBase7(7));
    }
}
