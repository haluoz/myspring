package com.lxj.leetcode.array;

/**
 * @author Xingjing.Li
 * @since 2022/1/4
 */
public class Convert1DArrayInto2DArray2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int length = original.length;
        if (length != m*n) return new int[0][0];
        int [][] ans = new int[m][n];
        for (int i = 0, index = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = original[index++];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Convert1DArrayInto2DArray2022 solution = new Convert1DArrayInto2DArray2022();
        int[] ints = {1, 2, 3};
        solution.construct2DArray(ints, 1, 3);
    }
}
