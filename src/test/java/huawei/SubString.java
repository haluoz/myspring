package huawei;

import java.util.Scanner;

/**
 * 截取字符串
 */
public class SubString {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            int num = Integer.parseInt(sc.nextLine());
            str = str.substring(0, num);
            System.out.println(str);
        }
    }
}
