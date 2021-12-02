package com.lxj.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xingjing.Li
 * @since 2021/12/1
 */
public class ConsecutiveCharacters1446 {

    public int maxPower(String s) {
        int ans = 1;
        int n = s.length();
        for (int i = 0; i < n; ) {
            int j = i+1;
            char cur = s.charAt(i);
            while (j < n && cur == s.charAt(j)){
                j++;
            }
            ans = Math.max(ans, j - i);
            i = j;
        }
        return ans;
    }

    public static void main(String[] args) {
        ConsecutiveCharacters1446 soulution = new ConsecutiveCharacters1446();
        System.out.println(soulution.maxPower("hooraaaaaaaaaaay"));
    }
}
