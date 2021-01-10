package com.lxj.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 找出字符串中第一个只出现一次的字符
 */
public class FindCharOccurOnceInString {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            char[] chars = sc.nextLine().toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for (char c : chars) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            boolean f = true;
            for (char ch : chars) {
                if (map.get(ch) == 1) {
                    System.out.println(ch);
                    f = false;
                    break;
                }
            }
            if (f) {
                System.out.println(-1);
            }
        }
    }
}
