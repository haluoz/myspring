package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2023/1/16
 */
public class SentenceSimilarityIII1813 {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        int i =0, j = 0;
        int n1 = s1.length;
        int n2 = s2.length;
        //前往后匹配相同
        while (i < n1 && i < n2 && s1[i].equals(s2[i])){
            i++;
        }
        //后往钱匹配相同
        while (j < n1 -i && j < n2 -i  && s1[n1-j-1].equals(s2[n2-j-1])){
            j++;
        }
        //最小值
        return i + j == Math.min(n1, n2);
    }

    public static void main(String[] args) {
        SentenceSimilarityIII1813 solution = new SentenceSimilarityIII1813();
//        solution.areSentencesSimilar("My name is Haley", "My Haley");
//        solution.areSentencesSimilar("of", "A lot of words");
        solution.areSentencesSimilar("Eating right now", "Eating");
    }
}
