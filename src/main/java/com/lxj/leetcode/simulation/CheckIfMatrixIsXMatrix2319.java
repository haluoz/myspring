package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2023/1/31
 */
public class CheckIfMatrixIsXMatrix2319 {

    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for(int i = 0; i<n; ++i) {
            for (int j = 0; j < n; ++j) {
                //对角判读
                if (i == j || (i + j) == (n - 1)) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else if (grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIfMatrixIsXMatrix2319 solution = new CheckIfMatrixIsXMatrix2319();
        int [][] matrix = {{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}};
        System.out.println(solution.checkXMatrix(matrix));
    }
}
