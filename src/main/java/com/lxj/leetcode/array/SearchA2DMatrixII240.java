package com.lxj.leetcode.array;

/**
 * @author Xingjing.Li
 * @since 2021/10/25
 */
public class SearchA2DMatrixII240 {
    // O(n2)
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int n1 = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n1; j++) {
                if (matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    // O(nlogn)
    public boolean searchMatrix1(int[][] matrix, int target) {
        int n = matrix.length - 1;
        for (int i = 0; i <= n; i++) {
            int l = 0 , r = matrix[0].length-1;
            while (l <= r){
                int mid = (l+r) >> 1;
                int num = matrix[i][mid];
                if (num == target){
                    return true;
                }else if (num > target){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrixII240 solution = new SearchA2DMatrixII240();
        int[][] matrix = //{{-5}};
                        {{1,4,7,11,15},
                        {2,5,8,12,19},
                        {3,6,9,16,22},
                        {10,13,14,17,24},
                        {18,21,23,26,30}};
        System.out.println(solution.searchMatrix1(matrix, 5));
    }
}
