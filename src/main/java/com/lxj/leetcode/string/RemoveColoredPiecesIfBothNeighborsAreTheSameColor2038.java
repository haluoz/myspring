package com.lxj.leetcode.string;

/**
 * @author Xingjing.Li
 * @since 2022/3/22
 */
public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor2038 {
    public boolean winnerOfGame(String colors) {
        char[] cs = colors.toCharArray();
        int n = cs.length;
        int a = 0, b = 0;
        for (int i = 1; i < n - 1; i++) {
            if (cs[i] == 'A' && cs[i - 1] == 'A' && cs[i + 1] == 'A') a++;
            if (cs[i] == 'B' && cs[i - 1] == 'B' && cs[i + 1] == 'B') b++;
        }
        return a > b;
    }

    public static void main(String[] args) {
        RemoveColoredPiecesIfBothNeighborsAreTheSameColor2038 solution = new RemoveColoredPiecesIfBothNeighborsAreTheSameColor2038();
        System.out.println(solution.winnerOfGame("AAABBBB"));
    }
}

