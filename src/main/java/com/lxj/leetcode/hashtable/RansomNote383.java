package com.lxj.leetcode.hashtable;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 */
public class RansomNote383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int [] hashtable = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            // 通过recode数据记录 magazine里各个字符出现次数
            hashtable[c-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            // 遍历ransomNote，在record里对应的字符个数做--操作
            char c = ransomNote.charAt(i);
            hashtable[c-'a']--;
            // 如果小于零说明 magazine里出现的字符，ransomNote没有
            if(hashtable[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote383 solution = new RansomNote383();
        solution.canConstruct("aa","aab");
    }
}
