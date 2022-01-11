package com.lxj.leetcode.simulation;


/**
 * @author Xingjing.Li
 * @since 2021/12/23
 */
public class BattleshipsInABoard {

    public int countBattleships(char[][] board){
        int ans = 0;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && board[i - 1][j] == 'X'){
                    continue;
                }
                if (j > 0 && board[i][j - 1] == 'X'){
                    continue;
                }
                if (board[i][j] == 'X') ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        BattleshipsInABoard solution = new BattleshipsInABoard();
        char[][] chars = new char[4][4];
        chars[0][0] = 'X';
        chars[0][3] = 'X';
        chars[1][3] = 'X';
        chars[2][3] = 'X';
        System.out.println(solution.countBattleships(chars));
    }
}
