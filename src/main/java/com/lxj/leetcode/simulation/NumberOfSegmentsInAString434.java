package com.lxj.leetcode.simulation;

import org.apache.tools.ant.types.resources.First;

/**
 * @author Xingjing.Li
 * @since 2021/10/12
 */
public class NumberOfSegmentsInAString434 {
    public int countSegments(String s) {
        int n  = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') continue;
            while ( i < n && s.charAt(i) != ' ' ) {
                i++;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfSegmentsInAString434 solution = new NumberOfSegmentsInAString434();
        System.out.println(solution.countSegments(", , , ,        a, eaefa"));
    }
}
