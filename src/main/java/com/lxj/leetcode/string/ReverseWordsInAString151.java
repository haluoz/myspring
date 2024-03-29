package com.lxj.leetcode.string;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 说明：
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 示例 1：
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * 输入："  hello world!  "
 * 输出："world! hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * 输入："a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * @author lee
 */
public class ReverseWordsInAString151 {

    public String reverseWords(String s) {
        StringBuilder sb = trimSpaces(s);

        // 翻转字符串
        reverse(sb, 0, sb.length() - 1);

        // 翻转每个单词
        reverseEachWord(sb);

        return sb.toString();

    }

    private StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' '){
            left++;
        }
        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' '){
            right--;
        }
        StringBuilder sb = new StringBuilder();
        // 将字符串间多余的空白字符去除
        while (left <= right) {
            char c = s.charAt(left);

            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') { // 根据StringBuilder最后一个字符判断是否空格是否添加空格进去
                sb.append(c);
            }

            ++left;
        }
        return sb;
    }

    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    private void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;
        while (start < n) {
            // 循环至单词的末尾
            while (end < n && sb.charAt(end) != ' ') {
                ++end;
            }
            // 翻转单词
            reverse(sb, start, end - 1);
            // 更新start，去找下一个单词
            start = end + 1;
            ++end;
        }
    }


    public static void main(String[] args) {
        ReverseWordsInAString151 solution = new ReverseWordsInAString151();
        solution.reverseWords("   leetcode   is  fun   ");
    }
}
