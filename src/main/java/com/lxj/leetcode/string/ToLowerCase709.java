package com.lxj.leetcode.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Xingjing.Li
 * @since 2021/12/15
 */
public class ToLowerCase709 {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch >= 65 && ch <= 90) {
                ch += 32;
            }
            sb.append(ch);
        }
        return sb.toString();
//        return s.toLowerCase();
    }

    public static void main(String[] args) {
        ToLowerCase709 solution = new ToLowerCase709();
        System.out.println(solution.toLowerCase("LOVELY"));
        List<String> list = Arrays.asList("测评模版2", "测评模版3", "测评模版1", "c");
        list.stream().sorted(Comparator.comparing(s -> s)).collect(Collectors.toList()).forEach(System.out::print);
    }
}
