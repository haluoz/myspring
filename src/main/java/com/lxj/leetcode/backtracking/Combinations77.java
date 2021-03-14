package com.lxj.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [[2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4]]
 *
 * @author lee
 */
public class Combinations77 {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if(n<=0 || k<=0 || k>n){
            return list;
        }
        generateCombination(n,k,1,new ArrayList<>());
        return list;
    }

    //求解C(N,k),当前找到的组合存储在C中，需要从start开始搜索新的元素
    private void generateCombination(int n, int k, int start, List<Integer> c){
        System.out.println(start + " " + c.toString());
        if (c.size() == k){
            list.add(new ArrayList<>(c));
            return;
        }
        for (int i = start; i <= n; i++) {
            c.add(i);
            generateCombination(n,k, i+1, c);
            c.remove((Integer)i);
        }
        return;
    }

    //回溯剪枝
    private void generateCombination(int n, int k, int start, List<Integer> c, String useless){
        System.out.println(start + " " + c.toString());
        if (c.size() == k){
            list.add(new ArrayList<>(c));
            return;
        }
        //还有k-c.size个空位，所以[i...n]中至少要有k-c.size个元素
        for (int i = start; i <= n-(k-c.size())+1; i++) {
            c.add(i);
            generateCombination(n,k, i+1, c,"");
            c.remove((Integer)i);
        }
        return;
    }

    public static void main(String[] args) {
        Combinations77 combinations = new Combinations77();
        System.out.println(combinations.combine(4, 2));
    }
}
