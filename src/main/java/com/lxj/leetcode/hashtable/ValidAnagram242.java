package com.lxj.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 字母异位词指字母相同，但排列不同的字符串。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class ValidAnagram242 {

    //哈希
    public boolean isAnagram(String s, String t) {
        int [] hashtable = new int[26];
        if (s.length() != t.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            //s.charAt(i) - 'a' -> 输出ASCII码表对应的值
            // t =116 a=97 -> 116-97 = 19
            hashtable[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            hashtable[s.charAt(i) - 'a']--;
        }
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] != 0){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram(boolean hashMap, String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)-1);
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() > 0){
                return false;
            }
        }
        return true;
    }

    //暴力法
    public boolean isAnagram(String s, String t,boolean force) {
        if(s.length() != t.length()){
            return false;
        }
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for(int i = 0;i<c1.length;i++){
            if(c1[i]!= c2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram242 solution = new ValidAnagram242();
        solution.isAnagram(true,"rat","cat");
    }
}
