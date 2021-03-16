package com.lxj.leetcode.string;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * @author lee
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        int oldLength = s.length();
        int index = 0;
        char[] array = new char[oldLength * 3];
        for (int i = 0; i < oldLength; i++) {
            char c = s.charAt(i);
            if ( c == ' '){
                array[index++] = '%';
                array[index++] = '2';
                array[index++] = '0';
            }else {
                array[index++] = c;
            }
        }
        return new String(array,0, index);
    }

    public static void main(String[] args) {
        ReplaceSpace solution = new ReplaceSpace();
        System.out.println(solution.replaceSpace("we are happy"));
    }
}
