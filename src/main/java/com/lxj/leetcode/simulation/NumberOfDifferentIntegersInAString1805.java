package com.lxj.leetcode.simulation;

import java.util.HashMap;

/**
 * @author Xingjing.Li
 * @since 2022/12/6
 */
public class NumberOfDifferentIntegersInAString1805 {

    public int numDifferentIntegers(String word) {
        int ans = 0;
        char[] chars = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; ) {
            if (Character.isLetter(chars[i])){
                i++;
                continue;
            }
            sb.append(chars[i]);
            int j = i + 1;
            while (j < chars.length && Character.isDigit(chars[j])){
                sb.append(chars[j]);
                j++;
            }
            i = j;
            String s = sb.toString();
            int length = s.length();
            if (length > 1) {
                int start = 0;
                int end = length-1;
                while (start < end && s.charAt(start) == '0'){
                    start++;
                }
                s = s.substring(start, length);
            }
            map.put(s,1);
            sb.setLength(0);
        }
        ans = map.size();
        return ans;
    }

    public static void main(String[] args) {
        NumberOfDifferentIntegersInAString1805 solution = new NumberOfDifferentIntegersInAString1805();
//        System.out.println(solution.numDifferentIntegers("gi851a851q8510v"));
        // test case 71
        System.out.println(solution.numDifferentIntegers("a1b01c001"));
        //test case 62
//        System.out.println(solution.numDifferentIntegers("0a0"));
    }
}
