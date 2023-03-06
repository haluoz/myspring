package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2023/1/29
 */
public class CountAsterisks2315 {

    public int countAsterisks(String s) {
        String[] split = s.split("\\|");
        int ans = 0;
        int n = split.length;
        for (int i = 0; i < n; i+=2) {
            String s1 = split[i];
            int n1 = s1.length();
            for (int j = 0; j < n1; j++) {
                char c = s1.charAt(j);
                if (c =='*') ans++;
            }
        }
        return ans;
    }

    public int countAsterisks1(String s) {
        boolean valid = true;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '|') {
                valid = !valid;
            } else if (c == '*' && valid) {
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        CountAsterisks2315 solution = new CountAsterisks2315();
        System.out.println(solution.countAsterisks1("yo|uar|e**|b|e***au|tifu|l"));
    }
}
