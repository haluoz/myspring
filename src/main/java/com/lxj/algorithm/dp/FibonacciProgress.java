package com.lxj.algorithm.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数列实现 -> 递归， 记忆化递归，动态规划
 */
public class FibonacciProgress {

    private Map<Integer,Integer> map = new HashMap<>();
    private int [] memo;

    //普通递归
    public int fib(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    //记忆化递归
    public int fibMemory(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        int n1 = fibMemory(n - 1);
        map.put(n-1, n1);
        int n2 = fibMemory(n - 2);
        map.put(n-1, n1);
        int res = (n1 + n2);
        map.put(n, res);
        return res;
    }

    public int fibMeno(int n){
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return fibMemory2(n);
    }

    //记忆化递归
    private int fibMemory2(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(memo[n] != -1){
            return memo[n];
        }
        int n1 = fibMemory2(n - 1);
        int n2 = fibMemory2(n - 2);
        memo[n] = n1 + n2;
        return n1 + n2;
    }

    public int fibDP(int n){
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        FibonacciProgress fibonacciProgress = new FibonacciProgress();
        System.out.println(fibonacciProgress.fib(4));
        System.out.println(fibonacciProgress.fibMemory(6));
        System.out.println(fibonacciProgress.fibMeno(6));
        System.out.println(fibonacciProgress.fibDP(4));
    }
}
