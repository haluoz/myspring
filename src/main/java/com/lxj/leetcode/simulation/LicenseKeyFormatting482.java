package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2021/10/12
 */
public class LicenseKeyFormatting482 {

    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
//        for (int i = 0, count = 0; i < s.length(); i++) {
        for (int i = s.length()-1, count = 0; i >= 0; i--) {
            if (s.charAt(i) == '-'){
                continue;
            }
            if (count == k){
                count = 0;
                sb.append("-");
            }
            sb.append(s.charAt(i));
            count++;
        }
        return sb.reverse().toString().toUpperCase();
    }

    public static void main(String[] args) {
        LicenseKeyFormatting482 solution = new LicenseKeyFormatting482();
        System.out.println(solution.licenseKeyFormatting("2-5g-3-J", 2));
    }
}
