package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2022/1/25
 */
public class CountOfMatchesInTournament1688 {
    public int numberOfMatches(int n) {
        int ans = 0;
        while (n > 1){
            if(n % 2 == 0){
                ans += n/2;
                n /= 2;
            }else {
                ans += (n - 1) / 2;
                n = (n - 1) / 2 + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountOfMatchesInTournament1688 solution = new CountOfMatchesInTournament1688();
        System.out.println(solution.numberOfMatches(14));
    }
}
