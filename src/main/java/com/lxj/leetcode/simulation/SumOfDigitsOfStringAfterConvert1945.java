package com.lxj.leetcode.simulation;

import java.util.HashMap;

/**
 * @author Xingjing.Li
 * @since 2022/12/15
 */
public class SumOfDigitsOfStringAfterConvert1945 {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        initPos(map);
        for (int i = 0; i < s.length(); i++) {
            Integer integer = map.get(s.charAt(i));
            if( integer != null){
                sb.append(integer);
            }
        }
        int ans = 0;
        String s1 = sb.toString();
        sb.setLength(0);
        for (int i = 0; i < k; i++) {
            ans = 0;
            for (int j = 0; j < s1.length(); j++) {
                ans += s1.charAt(j) - '0';
            }
            sb.setLength(0);
            sb.append(ans);
            s1 = sb.toString();
        }


        return ans;
    }

    private void initPos(HashMap<Character, Integer> map) {
        map.put('a', 1);
        map.put('b', 2);
        map.put('c', 3);
        map.put('d', 4);
        map.put('e', 5);
        map.put('f', 6);
        map.put('g', 7);
        map.put('h', 8);
        map.put('i', 9);
        map.put('j', 10);
        map.put('k', 11);
        map.put('l', 12);
        map.put('m', 13);
        map.put('n', 14);
        map.put('o', 15);
        map.put('p', 16);
        map.put('q', 17);
        map.put('r', 18);
        map.put('s', 19);
        map.put('t', 20);
        map.put('u', 21);
        map.put('v', 22);
        map.put('w', 23);
        map.put('x', 24);
        map.put('y', 25);
        map.put('z', 26);
    }

    public static void main(String[] args) {
        SumOfDigitsOfStringAfterConvert1945 solution = new SumOfDigitsOfStringAfterConvert1945();
        System.out.println(solution.getLucky("leetcode", 2));
    }
}
