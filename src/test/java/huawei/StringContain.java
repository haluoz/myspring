package huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 字符串字符匹配
 */
public class StringContain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String shortStr = sc.nextLine();
            String longStr = sc.nextLine();
            System.out.println(isContain(shortStr, longStr));
        }
    }

    private static boolean isContain(String shortStr, String longStr) {
        char[] shortChars = shortStr.toCharArray();
        char[] longChars = longStr.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char c: longChars) {
            set.add(c);
        }
        for (char c: shortChars){
            if (!set.contains(c)){
                return false;
            }
        }
        return true;
    }

}
