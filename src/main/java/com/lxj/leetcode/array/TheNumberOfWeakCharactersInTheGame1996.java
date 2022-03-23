package com.lxj.leetcode.array;

import java.util.Arrays;

/**
 * @author Xingjing.Li
 * @since 2022/1/28
 */
public class TheNumberOfWeakCharactersInTheGame1996 {

    public int numberOfWeakCharacters(int[][] ps) {
        int n = ps.length, ans = 0;
        Arrays.sort(ps, (a, b)->{
            if (a[0] != b[0]) return b[0] - a[0];
            return b[1] - a[1];
        });
        for (int i = 0, max = ps[0][1]; i < n; ) {
            int j = i;
            while (j < n && ps[j][0] == ps[i][0]) {
                if (i != 0 && ps[j][1] < max){
                    ans++;
                }
                j++;
            }
            max = Math.max(max, ps[i][1]);
            i = j;
        }
        return ans;
    }

    public static void main(String[] args) {
        TheNumberOfWeakCharactersInTheGame1996 solution = new TheNumberOfWeakCharactersInTheGame1996();
        int[][] characters = {{5, 5}, {6, 3}, {3, 6}};
        solution.numberOfWeakCharacters(characters);
    }
}
