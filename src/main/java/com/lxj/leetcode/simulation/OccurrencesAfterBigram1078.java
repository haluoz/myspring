package com.lxj.leetcode.simulation;

import java.util.ArrayList;

/**
 * @author Xingjing.Li
 * @since 2022/1/10
 */
public class OccurrencesAfterBigram1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] ss = text.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i +2 < ss.length; i++) {
            if (ss[i].equals(first) && ss[i + 1].equals(second)){
                list.add(ss[i+2]);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        OccurrencesAfterBigram1078 solution = new OccurrencesAfterBigram1078();
//        String text = "alice is a good girl she is a good student";
        String text = "jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd";
        System.out.println(solution.findOcurrences(text, "jkypmsxd", "jkypmsxd"));

    }
}
