package com.lxj.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author Xingjing.Li
 * @since 2021/10/12
 */
public class ThirdMaximumNumber414 {

    public int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums){
            set.add(i);
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list, (o1, o2) -> o1 <  o2 ? 1 : -1);
        return list.size() < 3 ? list.get(0) : list.get(2) ;
    }

    public static void main(String[] args) {
        ThirdMaximumNumber414 solution = new ThirdMaximumNumber414();
        System.out.println(solution.thirdMax(new int[]{1,2}));
    }
}
