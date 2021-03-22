package com.lxj.leetcode.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 */
public class ValidParentheses20 {

    private Deque<Character> stack;

    public ValidParentheses20() {
        stack = new ArrayDeque<>();
    }

    public boolean isValid(String s) {
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                Character parenthese = stack.pop();
                if (parenthese == '(' && c != ')'){
                    return false;
                }else if (parenthese == '[' && c != ']'){
                    return false;
                }else if (parenthese == '{' && c != '}'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses20 solution = new ValidParentheses20();
        solution.isValid("([{}]()");
    }
}
