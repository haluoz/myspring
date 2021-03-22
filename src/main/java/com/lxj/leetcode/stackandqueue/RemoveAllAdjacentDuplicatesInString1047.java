package com.lxj.leetcode.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"
 */
public class RemoveAllAdjacentDuplicatesInString1047 {

    public static String removeDuplicates(String s) {
        char[] cs = s.toCharArray();
        char[] d = new char[s.length()];
        int hh = 0, tt = -1;
        for (char c : cs) {
            if (hh <= tt && d[tt] == c) {
                tt--;
            } else {
                d[++tt] = c;
            }
        }
        return new String(d, 0, tt + 1);
    }

    public static void main(String[] args) {
        String s = "abbaca";
        RemoveAllAdjacentDuplicatesInString1047.removeDuplicates1(s);
    }

    public static String removeDuplicates1(String S) {
        char [] chars = S.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for(char c: chars){
            if(!stack.isEmpty()){
                if(stack.peek().equals(c)){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }else{
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        //由于stack的特性，字符串是反转的，需要在反转一次
        return sb.reverse().toString();
    }

}
