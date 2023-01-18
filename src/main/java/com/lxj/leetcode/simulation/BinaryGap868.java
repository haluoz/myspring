package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2022/4/24
 */
public class BinaryGap868 {

    public int binaryGap(int n) {
        int last = -1, ans = 0;
        for (int i = 0; n != 0; ++i) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        BinaryGap868 solution = new BinaryGap868();
        solution.binaryGap(22);
    }
}
