package com.lxj.leetcode.simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xingjing.Li
 * @since 2023/1/12
 */
public class EvaluateTheBracketPairsOfAString1807 {

    public String evaluate(String s, List<List<String>> knowledge){
        Map<String, String> dict = new HashMap<>();
        for (List<String> replace : knowledge) {
            dict.put(replace.get(0), replace.get(1));
        }
        boolean addKey = false;
        StringBuilder key = new StringBuilder();
        StringBuilder res = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '('){
                addKey = true;
            }  else if (c == ')') {
                if (dict.containsKey(key.toString())) {
                    res.append(dict.get(key.toString()));
                } else {
                    res.append('?');
                }
                addKey = false;
                key.setLength(0);
            } else {
                if (addKey) {
                    key.append(c);
                } else {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }

    /**
     * ac不了
     * @param s
     * @param knowledge
     * @return
     */
    public String evaluate1(String s, List<List<String>> knowledge) {
        int n = knowledge.size();
        if ( n != 0) {
            for (int i = 0; i < knowledge.size(); i++) {
                List<String> list = knowledge.get(i);
                String key = list.get(0);
                String value = list.get(1);
                System.out.println(key + ":" + value);
                key = "(" + key + ")";
                if (s.contains(key)) {
                    s = s.replace(key, value);
                } else if ( i == n-1){
                    s = replaceBracket(s);
                }
            }
        }else{
            s = replaceBracket(s);
        }
        return s;
    }

    private String replaceBracket(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                start = i;
            }else if (s.charAt(i) == ')'){
                end = i;
            }
        }
        if (start != 0 || end != 0) {
            sb.append(s);
            sb.delete(start, end + 1);
            sb.insert(start, "?");
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        EvaluateTheBracketPairsOfAString1807 solution = new EvaluateTheBracketPairsOfAString1807();
        List<String> strings = new ArrayList<>();
        List<List<String>> knowledge = new ArrayList<>();
        knowledge.add(strings);
//        strings.add("zib");
//        strings.add("c");
        strings.add("name");
        strings.add("bob");
        List<String> strings1 = new ArrayList<>();
        knowledge.add(strings1);
        strings1.add("age");
        strings1.add("two");
        System.out.println(solution.evaluate("(name)is(age)yearsold", knowledge));
    }
}
