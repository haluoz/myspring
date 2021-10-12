package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2021/10/9
 */
public class ConvertANumberToHexadecimal405 {
    public String toHex(int _num) {
        if (_num == 0) return "0";
        long num = _num;
        StringBuilder sb = new StringBuilder();
        if(num < 0) num = (long)(Math.pow(2, 32) + num);
        while (num != 0) {
            long u = num % 16;
            char c = (char)(u + '0');
            if (u >= 10) c = (char)(u - 10 + 'a');
            sb.append(c);
            num /= 16;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ConvertANumberToHexadecimal405 solution = new ConvertANumberToHexadecimal405();
        System.out.println(solution.toHex(26));
    }
}
