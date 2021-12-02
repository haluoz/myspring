package com.lxj.leetcode.simulation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xingjing.Li
 * @since 2021/12/2
 */
public class RelativeRanks506 {

    public String[] findRelativeRanks(int[] score) {
        String[] medals = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
        int n = score.length;
        String[] strings = new String[n];
        int[] sortedScore = score.clone();
        Arrays.sort(sortedScore);
        Map<Integer, Integer> map = new HashMap<> ();
        //获得排名
        for (int i = 0; i < n; i++) {
            map.put(sortedScore[i], n - 1 -i);
        }
        //获得奖牌
        for (int i = 0; i < n; i++) {
            Integer rank = map.get(score[i]);
            strings[i] = rank < 3 ? medals[rank] : String.valueOf(rank+1) ;
        }
        return strings;
    }

    public static void main(String[] args) {
        int [] score = {10,3,8,9,4};
        RelativeRanks506 solution = new RelativeRanks506();
        solution.findRelativeRanks(score);
    }
}
