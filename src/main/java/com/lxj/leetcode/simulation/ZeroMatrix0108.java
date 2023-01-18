package com.lxj.leetcode.simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 *
 * @author Xingjing.Li
 * @since 2022/9/30
 */
public class ZeroMatrix0108 {

    public void setZeroes(int[][] matrix) {
        int n = matrix.length,  m = matrix[0].length;
        boolean[] rows = new boolean[n], cols = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0){
                    rows[i] = cols[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rows[i] || cols[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        ZeroMatrix0108 solution = new ZeroMatrix0108();
        int [][] arr = {{1, 1, 1, 0},
                        {1, 0, 1, 1},
                        {1, 1, 1, 1}};
        solution.setZeroes(arr);
    }
}
