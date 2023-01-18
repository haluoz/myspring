package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 2022/10/12
 */
public class ReverseInteger7 {
    public int reverse(int x) {
        Integer num = x;
        String numStr = num.toString();
        char[] chars = numStr.toCharArray();
        for (int i = 0, j = numStr.length()-1; i <j; ) {
            if (chars[0] == '-'){
                swap(chars, ++i, j--);
            }else {
                swap(chars, i++, j--);
            }
        }
        try{
            int x1 = Integer.parseInt(String.valueOf(chars));
            return x1;
        }catch (Exception e){
            return 0;
        }
    }

    private void swap(char[] chars, int i, int j){
        char c1 = chars[i];
        chars[i] = chars[j];
        chars[j] = c1;
    }

    public static void main(String[] args) {
        ReverseInteger7 solution = new ReverseInteger7();
        solution.reverse(1534236469);
    }
}
