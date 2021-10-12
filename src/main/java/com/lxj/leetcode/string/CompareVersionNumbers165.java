package com.lxj.leetcode.string;

/**
 * @author Xingjing.Li
 * @since 2021/9/30
 */
public class CompareVersionNumbers165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int length = Math.max(v1.length, v2.length);
        for (int i = 0; i < length; i++) {
            int x = 0, y = 0;
            if (i < v1.length){
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2.length){
                y = Integer.parseInt(v2[i]);
            }
            if (x > y){
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }

    public int compareVersion1(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0, j =0;
        while (i < v1.length || j < v2.length){
            int x = 0, y = 0;
            if (i < v1.length) x = Integer.parseInt(v1[i++]);
            if (j < v2.length) y = Integer.parseInt(v2[j++]);
            if (x != y) return x > y ? 1 : -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers165 solution = new CompareVersionNumbers165();
        String version1 = "7.5.2.4";
        String version2 = "7.5.3";
        System.out.println(solution.compareVersion1(version1, version2));
    }
}
