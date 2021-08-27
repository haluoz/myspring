package com.lxj.leetcode.string;

/**
 * @author Xingjing.Li
 * @since 2021/8/23
 */
public class StringCompression443 {

    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                //把不同字母放在第一位
                chars[write++] = chars[read];
                //字母相同数量个数
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    //如字母数量个数大于10需要反转，不然结果不对
                    reverse(chars, anchor, write - 1);
                }
                //保存下一个读取的位置
                left = read + 1;
            }
        }
        return write;
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        StringCompression443 solution = new StringCompression443();
//        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
//        char[] chars  = {'a','a','a','b','b','a','a'};
        char[] chars  = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(solution.compress(chars));
    }
}
