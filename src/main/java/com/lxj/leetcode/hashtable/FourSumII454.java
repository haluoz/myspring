package com.lxj.leetcode.hashtable;

import java.util.HashMap;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * 输出:
 * 2
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class FourSumII454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到map中
        for (int a : A) {
            for (int b : B) {
                map.put(a+b, map.getOrDefault(a+b, 0)+1);
            }
        }
        //定义int变量count，用来统计a+b+c+d = 0 出现的次数
        int count = 0;
        //在遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，
        //就用count把map中key对应的value也就是出现次数统计出来
        for (int c : C) {
            for (int d : D) {
                if (map.containsKey(-c - d)) {
                    count += map.get(-c - d);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FourSumII454 solution = new FourSumII454();
        int [] A = {1,2};
        int [] B = {-2,-1};
        int [] C = {-1,2};
        int [] D = {0,2};
        solution.fourSumCount(A,B,C,D);
    }
}
