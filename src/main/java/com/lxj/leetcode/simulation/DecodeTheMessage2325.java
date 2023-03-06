package com.lxj.leetcode.simulation;

import java.util.HashMap;

/**
 * @author Xingjing.Li
 * @since 2023/2/1
 */
public class DecodeTheMessage2325 {

    public String decodeMessage(String key, String message) {
        StringBuilder sb = new StringBuilder();
        key = key.replace(" ", "");
        HashMap<Character, Character> map = new HashMap<>();
        int index = 0;
        for (int i =0; i< 26; i++){
            char c = key.charAt(index++);
            if (map.containsKey(c)){
                i--;
                continue;
            }
            map.put(c, (char) (i + 'a'));
        }
        map.put(' ', ' ');
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            sb.append(map.get(c));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeTheMessage2325 solution = new DecodeTheMessage2325();
        solution.decodeMessage("the quick brown fox jumps over the lazy dog",
                "vkbs bs t suepuv");
    }
}
