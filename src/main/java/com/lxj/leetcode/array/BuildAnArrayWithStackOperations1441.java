package com.lxj.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Xingjing.Li
 * @since 2022/10/17
 */
public class BuildAnArrayWithStackOperations1441 {

    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int targetN = target.length;
        for (int i = 0; i < targetN; i++) {
            set.add(target[i]);
        }
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (targetN == j) break;
            if (set.contains(i)){
                list.add("Push");
                j++;
            }else{
                list.add("Push");
                list.add("Pop");
            }
        }
        return list;
    }

    public static void main(String[] args) {
        BuildAnArrayWithStackOperations1441 solution = new BuildAnArrayWithStackOperations1441();
        int [] target = {1,3};
        System.out.println(solution.buildArray(target, 3));
    }
}
