package com.lxj.leetcode.array;

/**
 * @author Xingjing.Li
 * @since 2021/10/25
 */
public class SearchA2DMatrix74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length - 1;
        int l = 0, r = n;
        while (l <= r) {
            // 1 10 23
            int mid = (l+r) >> 1;
            if (matrix[mid][0] == target){
                return true;
            } else if (matrix[mid][0] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        int row = r;
        if (row == -1) row = 0;
        r = matrix[row].length -1 ;
        l = 0;
        while (l <= r){
            int mid = (l+r) >> 1;
            if (matrix[row][mid] == target){
                return true;
            }else if (matrix[row][mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return false;
    }

    public boolean searchMatrix1(int[][] mat, int t) {
        int m = mat.length, n = mat[0].length;

        // 第一次二分：定位到所在行（从上往下，找到最后一个满足 mat[x]][0] <= t 的行号）
        int l = 0, r = m - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (mat[mid][0] <= t) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        int row = r;
        if (mat[row][0] == t) return true;
        if (mat[row][0] > t) return false;

        // 第二次二分：从所在行中定位到列（从左到右，找到最后一个满足 mat[row][x] <= t 的列号）
        l = 0; r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (mat[row][mid] <= t) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int col = r;

        return mat[row][col] == t;
    }

    public static void main(String[] args) {
        SearchA2DMatrix74 solution = new SearchA2DMatrix74();
        int[][] matrix = {{1}};
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 60}};
        solution.searchMatrix(matrix,3);
    }
}
