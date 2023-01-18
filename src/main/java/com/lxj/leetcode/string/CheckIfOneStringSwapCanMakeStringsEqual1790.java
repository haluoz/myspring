package com.lxj.leetcode.string;

/**
 * @author Xingjing.Li
 * @since 2022/10/12
 */
public class CheckIfOneStringSwapCanMakeStringsEqual1790 {

    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length(), a = -1, b = -1;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i)){
                continue;
            }
            if (a == -1){
                //记录 第一个不同的问题
                a = i;
            } else if (b == -1) {
                //记录 第二个不同的问题
                b = i;
            }else {
                //大于两个不同的字符直接返回
                return false;
            }
        }
        if (a == -1) return true;
        if (b == -1) return false;
        //判断是否相等
        return s1.charAt(a) == s2.charAt(b) && s1.charAt(b) == s2.charAt(a);
    }

    public static void main(String[] args) {
        CheckIfOneStringSwapCanMakeStringsEqual1790 solution = new CheckIfOneStringSwapCanMakeStringsEqual1790();
//        System.out.println(solution.areAlmostEqual("abcd", "dcba"));
//        System.out.println(solution.areAlmostEqual("bank", "kanb"));
        System.out.println(solution.areAlmostEqual("bank", "bkna"));
//        System.out.println(solution.areAlmostEqual("attack", "defend"));
    }
}
