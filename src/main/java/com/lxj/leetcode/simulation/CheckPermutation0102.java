package com.lxj.leetcode.simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xingjing.Li
 * @since 2022/9/30
 */
public class CheckPermutation0102 {

    public boolean CheckPermutation(String s1, String s2) {
//        char [] chars = s1.toCharArray();
//        Map<Character, Integer> map = new HashMap<Character, Integer>();
//        for(int i = 0; i < chars.length; i++){
//            map.put(chars[i], map.getOrDefault(chars[i],0)+1);
//        }
//        for(int i = 0; i < s2.length() ; i++){
//            if(map.get(s2.charAt(i)) == null){
//                return false;
//            }
//        }
//        return true;
        int n = s1.length(), m = s2.length(), tot = 0;
        if (n != m) return false;
        int[] cnts = new int[256];
        for (int i = 0; i < n; i++) {
            if (++cnts[s1.charAt(i)] == 1) tot++;
            if (--cnts[s2.charAt(i)] == 0) tot--;
        }
        return tot == 0;
    }

    public static void main(String[] args) {
        CheckPermutation0102 solution = new CheckPermutation0102();
        solution.CheckPermutation("abc", "bad");
    }
}
