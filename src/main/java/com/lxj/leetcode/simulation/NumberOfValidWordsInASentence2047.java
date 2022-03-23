package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2022/1/27
 */
public class NumberOfValidWordsInASentence2047 {
    public int countValidWords(String sentence) {
        int ans = 0;
        String[] ss = sentence.split(" ");
        for (int i = 0; i < ss.length; i++) {
            if (check(ss[i])) ans++;
        }
        return ans;
    }

    private boolean check(String s) {
        int n = s.length();
        if (n == 0) return false;
        for (int i = 0, c1 = 0, c2 = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) return false;
            if (c == ' ') return false;
            if (c == '-' && ++c1 >= 0) {
                if (c1 > 1 || (i == 0 || i == n - 1)) return false;
                if (!Character.isLetter(s.charAt(i - 1)) || !Character.isLetter(s.charAt(i + 1))) return false;
            }
            if ((c == '!' || c == '.' || c == ',') && ++c2 >= 0) {
                if (c2 > 1 || (i != n - 1)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NumberOfValidWordsInASentence2047 solution = new NumberOfValidWordsInASentence2047();
        System.out.println(solution.countValidWords("alice and  bob are playing stone-game10"));
    }
}
