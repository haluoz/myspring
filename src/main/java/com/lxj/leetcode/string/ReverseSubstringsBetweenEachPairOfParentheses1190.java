package com.lxj.leetcode.string;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses1190 {

    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c == '('){
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (c==')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseSubstringsBetweenEachPairOfParentheses1190 solution = new ReverseSubstringsBetweenEachPairOfParentheses1190();
        String str = "(ed(et(oc))el)";
        System.out.println(solution.reverseParentheses(str));
    }
}
