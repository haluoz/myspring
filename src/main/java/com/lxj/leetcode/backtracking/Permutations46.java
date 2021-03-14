package com.lxj.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 输入: [1,2,3]
 * 输出:
 * [ [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]]
 * @author lee
 */
public class Permutations46 {

    List<List<Integer>> list = new ArrayList<>();
    boolean [] used;

    public List<List<Integer>> permute(int[] nums) {
        if ( nums.length  == 0){
            return list;
        }
        used = new boolean[nums.length];
        generatePermutation(nums, 0, new ArrayList<>());
        return list;
    }

    private void generatePermutation(int[] nums, int index, List<Integer> p ){
        System.out.println("Depth: " + index + " "  + p.toString());
        if (index == nums.length){
            list.add(new ArrayList<>(p));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //contains
            if (!used[i]){
                p.add(nums[i]);
                used[i] = true;
                generatePermutation(nums, index+1, p);
                p.remove((Integer) nums[i]);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permutations46 permutations = new Permutations46();
        int[] nums = {1,2,3};
        System.out.println(permutations.permute(nums).toString());
    }
}
