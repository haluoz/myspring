package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2022/2/21
 */
public class OneBitAndTwoBitCharacters717 {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, idx = 0;
        while (idx < n -1){
            if (bits[idx] == 0){
                idx++;
            }else {
                idx += 2;
            }
        }
        return idx == n-1;
    }

    public static void main(String[] args) {
        OneBitAndTwoBitCharacters717 solution = new OneBitAndTwoBitCharacters717();
        int[] ints = {1, 0, 1};
        System.out.println(solution.isOneBitCharacter(ints));
    }
}
