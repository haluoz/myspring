package com.lxj.leetcode.hashtable;

import java.util.HashMap;

/**
 * @author Xingjing.Li
 * @since 2023/1/17
 */
public class CountNicePairsInAnArray1814 {

    public int countNicePairs(int[] nums) {
        int mod = 1000000007;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int temp = i, j =0;
            // j = reverse(i)
            while (temp > 0){
                j = j * 10 + temp % 10;
                temp /= 10;
            }
            //sum ans
            ans = (ans + map.getOrDefault(i - j, 0)) % mod;
            //put same key and sum value in hashmap
            map.put(i-j, map.getOrDefault(i-j, 0)+1);
        }

        return ans % mod;
    }

    public static void main(String[] args) {
        CountNicePairsInAnArray1814 solution = new CountNicePairsInAnArray1814();
        solution.countNicePairs(new int[]{13,10,35,24,76});
    }
}
