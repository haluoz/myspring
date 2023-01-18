package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2022/12/8
 */
public class DetermineColorOfAChessboardSquare1812 {

    public boolean squareIsWhite(String coordinates) {
        char letter = coordinates.charAt(0);
        char number = coordinates.charAt(1);
        int i = letter;
        boolean ans = false;
        if (i % 2 == 1 && number % 2 == 1){
            ans = false;
        }else if (i % 2 == 1 && number % 2 == 0){
            ans = true;
        }else if (i % 2 == 0 && number % 2 == 1){
            ans = true;
        } else if (i % 2 == 0 && number % 2 == 0){
            ans = false;
        }
        return ans;
    }

    public static void main(String[] args) {
        DetermineColorOfAChessboardSquare1812 solution = new DetermineColorOfAChessboardSquare1812();
        System.out.println(solution.squareIsWhite("h3"));
    }
}
