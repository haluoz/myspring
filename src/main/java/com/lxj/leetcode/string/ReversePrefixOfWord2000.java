package com.lxj.leetcode.string;

/**
 * @author Xingjing.Li
 * @since 2022/2/7
 */
public class ReversePrefixOfWord2000 {
    public String reversePrefix(String word, char ch) {
        char[] chars = word.toCharArray();
        int index = 0, temp = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ch){
                index = i;
                break;
            }
        }
        while (temp < index){
            char c = chars[temp];
            chars[temp] = chars[index];
            chars[index] = c;
            index--;
            temp++;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        ReversePrefixOfWord2000 solution = new ReversePrefixOfWord2000();
        System.out.println(solution.reversePrefix("abcdefd", 'd'));
    }
}
