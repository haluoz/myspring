package com.lxj.leetcode.simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xingjing.Li
 * @since 2022/2/15
 */
public class LuckyNumbersInAMatrix1380 {
    int N = 55;
    int[] row = new int[N], col = new int[N];
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            row[i] = 100001;
            for (int j = 0; j < m; j++) {
                //找到每行的最小值放入数组
                row[i] = Math.min(row[i], matrix[i][j]);
                //找到每列的最大值放入数组
                col[j] = Math.max(col[j], matrix[i][j]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int t = matrix[i][j];
                //判断每个数字是否和数组row和col相等
                if (t == row[i] && t == col[j]) ans.add(t);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LuckyNumbersInAMatrix1380 solution = new LuckyNumbersInAMatrix1380();
        int [][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        solution.luckyNumbers(matrix);
    }
}
