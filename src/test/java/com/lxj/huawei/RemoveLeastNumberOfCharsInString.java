package com.lxj.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 删除字符串中出现次数最少的字符
 */
public class RemoveLeastNumberOfCharsInString {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.next();
            char [] chars = str.toCharArray();
            // Map记录每个字母的次数
            Map<Character, Integer> map = new HashMap<>();
            for(int i =0;i<chars.length;i++){
                map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
            }
            // 找出最小值
            int min = Integer.MAX_VALUE;
            for(int time: map.values()){
                min = Math.min(time,min);
            }
            StringBuilder sb = new StringBuilder();
            for (char ch : chars) {
                if (map.get(ch) != min) {
                    sb.append(ch);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
