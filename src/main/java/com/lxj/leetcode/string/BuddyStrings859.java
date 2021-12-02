package com.lxj.leetcode.string;

/**
 * 思维不能被固化了，实际上并不需要去交换位置
 * @author Xingjing.Li
 * @since 2021/11/23
 */
public class BuddyStrings859 {

    public boolean buddyStrings(String s, String goal) {
        int n = s.length(), m = goal.length();
        if (n != m) return false;
        int[] cnt1 = new int[26], cnt2 = new int[26];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a = s.charAt(i) - 'a', b = goal.charAt(i) - 'a';
            cnt1[a]++; cnt2[b]++;
            if (a != b) sum++;
        }
        boolean ok = false;
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
            if (cnt1[i] > 1) ok = true;
        }
        return sum == 2 || (sum == 0 && ok);
    }
    public static void main(String[] args) {
        BuddyStrings859 solution = new BuddyStrings859();
        System.out.println(solution.buddyStrings("aaaaaaabc", "aaaaaaacb"));
    }
}
