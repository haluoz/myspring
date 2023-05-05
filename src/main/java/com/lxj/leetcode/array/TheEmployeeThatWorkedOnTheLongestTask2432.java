package com.lxj.leetcode.array;

/**
 * @author Xingjing.Li
 * @since 5/5/2023
 */
public class TheEmployeeThatWorkedOnTheLongestTask2432 {
    // refactor
    public int hardestWorker(int n, int[][] logs) {
        int ans = logs[0][0];
        int maxTime = logs[0][1];
        for (int i = 1; i < logs.length; i++) {
            int id = logs[i][0];
            int cost = logs[i][1] - logs[i - 1][1];
            if (cost > maxTime){
                maxTime = cost;
                ans = id;
            }
            if (cost == maxTime){
                ans = Math.min(ans, id);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TheEmployeeThatWorkedOnTheLongestTask2432 solution = new TheEmployeeThatWorkedOnTheLongestTask2432();
//        int [][] logs = {{0,3},{2,5},{0,9},{1,15}};
//        int [][] logs = {{0,10},{1,20}};
        int [][] logs = {{36,3},{1,5},{12,8},{25,9},{53,11},{29,12},{52,14}};
        System.out.println(solution.hardestWorker(10, logs));
    }
}
