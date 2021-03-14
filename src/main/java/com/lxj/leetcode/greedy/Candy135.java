package com.lxj.leetcode.greedy;

import java.util.Arrays;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * 示例 1：
 * 输入：[1,0,2]
 * 输出：5
 * 解释：你可以分别给这三个孩子分发 2、1、2 颗糖果
 * @author Administrator
 */
public class Candy135 {

    public int candy(int[] ratings) {
        int n  = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        //先给所有学生 11 颗糖
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        //左至右遍历学生ratings
        for (int i = 1; i < n; i++) {
            //如i学生的rating比前一个学生大，将多获得一颗糖果
            if (ratings[i] > ratings[i-1]){
                left[i] = left[i-1]+1;
            }
        }
        //获得left中记录的最后一个糖果
        int count = left[ratings.length - 1];
        //右至左遍历学生ratings
        for (int i = n - 2; i >= 0; i--) {
            //如i学生的rating比前一个学生大，将多获得一颗糖果
            if (ratings[i] > ratings[i+1]){
                right[i] = right[i+1] +1;
            }
            //count+=左右的最大值
            count += Math.max(left[i], right[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        Candy135 solution = new Candy135();
        int [] ratings = {5,7,8,3,4,1};
        solution.candy(ratings);
    }
}
