package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2022/3/3
 */
public class AddDigits258 {

    public int addDigits(int num) {
        int ans = 0;
        String s = String.valueOf(num);
        int n = s.length();
        if (n == 1) {
            return num;
        }
        while ( n > 1){
            for (int i = 0; i < n; i++) {
                ans += Integer.parseInt(String.valueOf(s.charAt(i)));
            }
            s = String.valueOf(ans);
            n = s.length();
            if (n > 1) {
                ans = 0;
            }
        }
        return ans;
    }

    public int addDigits1(int num) {
        while (num > 9) {
            int t = 0;
            while (num != 0) {
                t += num % 10;
                num /= 10;
            }
            num = t;
        }
        return num;
    }

    public static void main(String[] args) {
        AddDigits258 solution = new AddDigits258();
        System.out.println(solution.addDigits1(38));
    }
}
