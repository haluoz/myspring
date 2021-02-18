package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class ImageReorganization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str= sc.nextLine();
            char[] chars= str.toCharArray();
            Arrays.sort(chars);
            for(char c :chars ){
                System.out.print(c);
            }
            System.out.println();

        }
    }
}
