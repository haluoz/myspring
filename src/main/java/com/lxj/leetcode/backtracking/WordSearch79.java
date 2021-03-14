package com.lxj.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lee
 */
public class WordSearch79 {

    int [][] direction = {{-1,0},{0,1},{1,0},{0,-1}};
    int m,n;
//    List<List<Boolean>> visited;
    boolean [][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchWord(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int startx, int starty){
        if (index == word.length() - 1){
            return board[startx][starty] == word.charAt(index);
        }
        if(board[startx][starty] == word.charAt(index)){
            visited[startx][starty] = true;
            //从startx，starty出发，向4个方向寻找
            for (int i = 0; i < 4; i++) {
                int newX = startx + direction[i][0];
                int newY = starty + direction[i][1];
                if (inArea(newX,newY) && visited[newX][newY]){
                    if(searchWord(board, word, index + 1, newX, newY)){
                        return true;
                    }
                }
            }
            visited[startx][starty] = false;
        }
        return  false;

    }

    private boolean inArea(int newX, int newY) {
        if (newX>=0 && newX< m && newY >=0 && newY < n){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
