package com.lxj.leetcode.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * @author lee
 */
public class PalindromePartitioning131 {

    List<List<String>> list = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() ==0){
            return list;
        }
        generatePalindrome(s.toCharArray(), 0, new ArrayDeque<>());
        return list;
    }

    private void generatePalindrome(char [] chars, int index, Deque<String> result){
        if ( index == chars.length){
            list.add(new ArrayList<>(result));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            if (!checkPalindrome(index, i , chars)){
                continue;
            }
            System.out.println("index:"+index + " i: "+i+ " " + new String(chars,index, i+1-index));
            result.addLast(new String(chars,index, i+1-index));
            generatePalindrome(chars, i+1, result);
            result.removeLast();
        }
        return;
    }

    private boolean checkPalindrome(int left, int right, char [] chars){
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public List<List<String>> partition(String s, String useless) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // Stack 这个类 Java 的文档里推荐写成 Deque<Integer> stack = new ArrayDeque<Integer>();
        // 注意：只使用 stack 相关的接口
        Deque<String> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        dfs(charArray, 0, len, stack, res);
        return res;
    }

    /**
     * @param charArray
     * @param index     起始字符的索引
     * @param len       字符串 s 的长度，可以设置为全局变量
     * @param path      记录从根结点到叶子结点的路径
     * @param res       记录所有的结果
     */
    private void dfs(char[] charArray, int index, int len, Deque<String> path, List<List<String>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < len; i++) {
            // 因为截取字符串是消耗性能的，因此，采用传子串下标的方式判断一个子串是否是回文子串
            if (!checkPalindrome(charArray, index, i)) {
                continue;
            }
            System.out.println("index:"+index + " i: "+i+ " " + new String(charArray,index, i+1-index));
            path.addLast(new String(charArray, index, i + 1 - index));
            dfs(charArray, i + 1, len, path, res);
            path.removeLast();
        }
    }

    /**
     * 这一步的时间复杂度是 O(N)，优化的解法是，先采用动态规划，把回文子串的结果记录在一个表格里
     *
     * @param charArray
     * @param left      子串的左边界，可以取到
     * @param right     子串的右边界，可以取到
     * @return
     */
    private boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning131 solution = new PalindromePartitioning131();
        System.out.println(solution.partition("abbab").toString());
    }
}
