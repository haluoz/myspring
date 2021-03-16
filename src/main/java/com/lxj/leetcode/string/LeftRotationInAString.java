package com.lxj.leetcode.string;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 * @author lee
 */
public class LeftRotationInAString {

    public String reverseLeftWords(String s, int n) {
        char [] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for(int i =0;i<chars.length;i++){
            if(i+1 <= n){
                sb.append(chars[i]);
            }else{
                sb1.append(chars[i]);
            }
        }
        return sb1.toString()+sb.toString();
    }

    public String reverseLeftWords(int n,String s) {
        char[] chars = s.toCharArray();
        //先反转前n的子串 -> bacdefg
        reverse(chars,0, n-1);
        //再反转n到末尾的子串 -> bagfedc
        reverse(chars,n,chars.length-1);
        //反转整个字符串：cdefgab
        reverse(chars,0, chars.length-1);
        return new String(chars,0, chars.length);
    }

    private void reverse(char [] chars, int left, int right) {
        while (left < right) {
            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        LeftRotationInAString solution = new LeftRotationInAString();
        System.out.println(solution.reverseLeftWords(2,"abcdefg"));
    }
}
