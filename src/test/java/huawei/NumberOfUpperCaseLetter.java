package huawei;

import java.util.Scanner;

/**
 *统计大写字母个数
 */
public class NumberOfUpperCaseLetter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char [] chars = sc.nextLine().toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if(String.valueOf(chars[i]).matches("[A-Z]")){
                count++;
            }
        }
        System.out.println(count);
    }
}
