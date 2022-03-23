package com.lxj.leetcode.simulation;

import java.util.Arrays;

/**
 * @author Xingjing.Li
 * @since 2022/3/18
 */
public class SimpleBankSystem2043 {
    private long[] account;

    public SimpleBankSystem2043(long[] balance) {
        account = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!check(account1) || !check(account2)) return false;
        if (this.account[account1-1] >= money) {
            this.account[account1-1] -= money;
            this.account[account2-1] += money;
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if (!check(account)) return false;
        this.account[account-1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!check(account)) return false;
        if (this.account[account-1] >= money) {
            this.account[account-1] -= money;
            return true;
        }
        return false;
    }

    private boolean check(int account){
        return account >= 1 && account <= this.account.length;
    }

    public long[] getAccount() {
        return account;
    }

    public static void main(String[] args) {
        SimpleBankSystem2043 bank = new SimpleBankSystem2043(new long[]{10, 100, 20, 50, 30});
        System.out.println(bank.withdraw(3, 10));
        System.out.println(bank.transfer(5, 1, 10));
        System.out.println(bank.deposit(5, 20));
        System.out.println(bank.transfer(3, 4, 15));
        System.out.println(bank.withdraw(10, 50));
        System.out.println(Arrays.toString(bank.getAccount()));
    }
}


