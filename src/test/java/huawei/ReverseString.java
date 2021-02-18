package huawei;

import java.util.Scanner;

/**
 * 字符串逆序
 */
public class ReverseString {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        char [] chars = sentence.toCharArray();
        for(int i =chars.length-1; 0<=i;i--){
            System.out.print(chars[i]);
        }

    }
}
