package huawei;

import java.util.Scanner;

/**
 * 提取不重复数
 */
public class ExtractNonRepetableNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char [] chars = str.toCharArray();
        String result = "";
        for(int i = chars.length - 1; i>=0;i--){
            if(!result.contains(chars[i]+"")){
                result+=chars[i];
            }
        }
        System.out.println(result);
    }
}
