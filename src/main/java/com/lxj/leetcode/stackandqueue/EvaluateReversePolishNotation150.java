package com.lxj.leetcode.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 示例 1：
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 示例 3：
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * 该算式转化为常见的中缀算术表达式为：
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class EvaluateReversePolishNotation150 {
    
    private Deque<Integer> stack = new ArrayDeque<>();

    public int evalRPN(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            String symbol = tokens[i];
            if (symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/")){
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                if (symbol.equals("+")){
                    stack.push(num2+num1);
                }
                if (symbol.equals("-")){
                    stack.push(num2-num1);
                }
                if (symbol.equals("*")){
                    stack.push(num2*num1);
                }
                if (symbol.equals("/")){
                    stack.push(num2/num1);
                }
            }else{
                stack.push(Integer.parseInt(symbol));
            }

        }
        int result = stack.poll();
        return result;
    }

    public static void main(String[] args) {
        String [] tokens = {"4","13","5","/","+"};
        EvaluateReversePolishNotation150 solution = new EvaluateReversePolishNotation150();
        solution.evalRPN(tokens);
    }
}
