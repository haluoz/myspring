package com.lxj.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xingjing.Li
 * @since 2022/3/17
 */
public class LongestWordInDictionary720 {
    public String longestWord(String[] words) {
        String ans = "";
        Set<String> set = new HashSet<>();
        for (String s : words) set.add(s);
        for (String s : set) {
            int n = s.length(), m = ans.length();
            if (n < m) continue;
            //如果长度相等返回字典序最小的单词
            if (n == m && s.compareTo(ans) > 0) continue;
            boolean ok = true;
            for (int i = 1; i <= n && ok; i++) {
                String sub = s.substring(0, i);
                //不包含子串设为false
                if (!set.contains(sub)) ok = false;
            }
            if (ok) ans = s;
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestWordInDictionary720 solution = new LongestWordInDictionary720();
        solution.longestWord(new String[]{"a","banana","app","appl","ap","apply","apple"});
    }
}
