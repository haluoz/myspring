package com.lxj.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * @author lee
 */
public class LetterCombinationsOfAPhoneNumber17 {

    private final String [] letterMap = {
            " ",  //0
            "", //1
            "abc", //2
            "def", //3
            "ghi", //4
            "jkl", //5
            "mno", //6
            "pqrs", //7
            "tuv", //8
            "wxyz" //9
    };
    ArrayList<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()){
            return list;
        }
        findCombination(digits, 0 , "");
        return list;
    }

    private void findCombination(String digit, int index, String s){
        System.out.println(index + " " + s);
        if (index == digit.length()){
            list.add(s);
            return;
        }
        char c = digit.charAt(index);
        String letters = letterMap[c-'0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digit, index+1, s+letters.charAt(i));
        }
        return;
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber17 combinations = new LetterCombinationsOfAPhoneNumber17();
        combinations.letterCombinations("234");
    }
}
