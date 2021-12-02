package com.lxj.leetcode.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xingjing.Li
 * @since 2021/10/21
 */
public class WordDictionary {

    public WordDictionary() {
    }

    public void addWord(String word) {
    }

    public boolean search(String word) {
        return false;
    }

    public static void main(String[] args) {
        WordDictionary solution = new WordDictionary();
        solution.addWord("bad");
        solution.addWord("dad");
        solution.addWord("mad");
        System.out.println(solution.search("dad"));
        System.out.println(solution.search("b.."));
    }
}
