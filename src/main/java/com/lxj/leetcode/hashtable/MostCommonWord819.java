package com.lxj.leetcode.hashtable;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Xingjing.Li
 * @since 2022/4/24
 */
public class MostCommonWord819 {

    public String mostCommonWord(String s, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String b : banned) set.add(b);
        char[] cs = s.toCharArray();
        int n = cs.length;
        String ans = null;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ) {
            if (!Character.isLetter(cs[i]) && ++i >= 0) continue;
            int j = i;
            while (j < n && Character.isLetter(cs[j])) j++;
            String sub = s.substring(i, j).toLowerCase();
            i = j + 1;
            if (set.contains(sub)) continue;
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            if (ans == null || map.get(sub) > map.get(ans)) ans = sub;
        }
        return ans;
    }

    public static void main(String[] args) {
        MostCommonWord819 solution = new MostCommonWord819();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String [] banned = {"hit"};
        System.out.println(solution.mostCommonWord(paragraph, banned));
    }
}
