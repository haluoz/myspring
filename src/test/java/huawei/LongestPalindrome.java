package huawei;

import java.util.Scanner;

/**
 * 最长回文子串
 * 给定一个仅包含小写字母的字符串，求它的最长回文子串的长度。
 * 所谓回文串，指左右对称的字符串。
 * 所谓子串，指一个字符串删掉其部分前缀和后缀（也可以不删）的字符串
 */
public class LongestPalindrome {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(getPalindrome(str));
        }
    }

    public static int getPalindrome(String str){
        int count =1;
        StringBuffer sb = new StringBuffer(str);
        //反转字符串
        String temp = sb.reverse().toString();
        //获取所有子串，查看翻转后的字符串是否包含该子串
        for (int i = temp.length(); i >= 1; i--) {
            for (int j = 0; j < temp.length() - i; j++) {
                // cdabbacc -> ccabbadc
                // ccabbadc -> ccabbad 第二次循环
                // ccabbad -> ccabba 第三次循环
                // ccabbad -> cabbad 第三次循环
                String tempSubString = temp.substring(j,j + i);
                if(str.contains(tempSubString)){
                    return i;
                }
            }
        }
        return count;
    }
}
