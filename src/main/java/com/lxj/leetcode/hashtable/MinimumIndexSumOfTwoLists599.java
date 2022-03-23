package com.lxj.leetcode.hashtable;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xingjing.Li
 * @since 2022/3/14
 */
public class MinimumIndexSumOfTwoLists599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int n = list1.length, m = list2.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(list1[i], i);
        List<String> ans = new ArrayList<>();
        int min = 3000;
        for (int i = 0; i < m; i++) {
            String s = list2[i];
            if (!map.containsKey(s)) continue;
            if (i + map.get(s) < min) {
                ans.clear();
                min = i + map.get(s);
                ans.add(s);
            } else if (i + map.get(s) == min) {
                ans.add(s);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }

    public static void main(String[] args) {
        MinimumIndexSumOfTwoLists599 solution = new MinimumIndexSumOfTwoLists599();
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        solution.findRestaurant(list1, list2);
        LocalDate localDate = LocalDate.now().minusDays(1);
        long timestamp = localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
        System.out.println(timestamp);
    }
}
