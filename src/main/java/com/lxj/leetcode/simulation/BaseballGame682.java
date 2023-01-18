package com.lxj.leetcode.simulation;

import com.lxj.leetcode.bst.TreeNode;

import java.nio.file.DirectoryStream;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author Xingjing.Li
 * @since 2022/3/28
 */
public class BaseballGame682 {
    int cur = 0;
    int [] numbers;
    public int calPoints(String[] ops) {
        int ans = 0, n = ops.length;
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            String operation = ops[i];
            if ("C".equals(operation)){
                numbers[--cur] = 0;
            }else if ("D".equals(operation)){
                int prev = cur;
                prev--;
                numbers[cur] = 2 * numbers[prev];
                cur++;
            }else if ("+".equals(operation)){
                int prev = cur;
                prev--;
                numbers[cur] += numbers[prev];
                numbers[cur] += numbers[--prev];
                cur++;
            }else{
                numbers[cur] = Integer.parseInt(operation);
                cur++;
            }
        }
        for (int i = 0; i < n; i++) {
            ans += numbers[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        BaseballGame682 solution = new BaseballGame682();
        String[] ops = {"36","28","70","65","C","+","33","- 46","84","C"};
        System.out.println(solution.calPoints(ops));
        List<Integer> integers = Arrays.asList(1, 2, 3);
    }
}
