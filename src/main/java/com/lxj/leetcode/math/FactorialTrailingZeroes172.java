package com.lxj.leetcode.math;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Xingjing.Li
 * @since 2022/3/25
 */
public class FactorialTrailingZeroes172 {

    public int trailingZeroes(int n) {
//        return 0 == n ? 0 : n / 5 + trailingZeroes(n / 5);
        if (n == 0 ) return 0;
        int ans = 0;
        while (n / 5 > 0){
             n /= 5;
             ans += n;
        }
        return ans;
    }

    public static void main(String[] args) {
        FactorialTrailingZeroes172 solution = new FactorialTrailingZeroes172();
        System.out.println(solution.trailingZeroes(10));
//        ReentrantLock reentrantLock = new ReentrantLock();
//        Condition condition = reentrantLock.newCondition();
//        condition.signalAll();
//        reentrantLock.lock();
//        reentrantLock.unlock();
    }
}
