package com.lxj.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xingjing.Li
 * @since 2021/10/18
 */
public class RepeatedDNASequences187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i+10 <= s.length(); i++){
            String word = s.substring(i, i+10);
            int count = map.getOrDefault(word, 0);
            if(count == 1){
                list.add(word);
            }
            map.put(word, count+1);
        }
        System.out.println(list.size());
        return list;
    }

    public static void main(String[] args) {
        RepeatedDNASequences187 solution = new RepeatedDNASequences187();
        String s = "CAAAAAAAAAB";
        solution.findRepeatedDnaSequences(s);
    }
}
