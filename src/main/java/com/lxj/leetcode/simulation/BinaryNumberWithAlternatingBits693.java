package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2022/3/28
 */
public class BinaryNumberWithAlternatingBits693 {
//    public boolean hasAlternatingBits(int n) {
//        int prev = 2;
//        while (n != 0) {
//            int cur = n % 2;
//            if (cur == prev) {
//                return false;
//            }
//            prev = cur;
//            n /= 2;
//        }
//        return true;
//    }

    public boolean hasAlternatingBits(int n) {
        int cur = -1;
        while (n != 0) {
            int u = n & 1;
            if ((cur ^ u) == 0) return false;
            cur = u; n >>= 1;
        }
        return true;
    }

//    public boolean hasAlternatingBits(int n) {
//        if (n == 0) return false;
//        String binary = Integer.toBinaryString(n);
//        for (int i = 0; i < binary.length()-1; i++) {
//            char c1 = binary.charAt(i);
//            char c2 = binary.charAt(i+1);
//            if (c1 == c2) return false;
//        }
//        return true;
//    }

    public static void main(String[] args) {
        BinaryNumberWithAlternatingBits693 solution = new BinaryNumberWithAlternatingBits693();
        System.out.println(solution.hasAlternatingBits(5));
    }
}
