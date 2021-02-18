package huawei;

import java.util.Scanner;

public class FindBinaryNumberOneCount {
    public static void main1(String[] args) {
            Scanner in = new Scanner(System.in);
            int number = in.nextInt();
            String binary = Integer.toBinaryString(number);
            char [] chars = binary.toCharArray();
            int count = 0;
            for(int i=0; i<chars.length;i++){
                if(chars[i] == '1'){
                    count++;
                }
            }
            System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str =in.nextLine();
        int n = Integer.parseInt(str);
        String s = Integer.toBinaryString(n);
        int cnt = 0;
        for(char c : s.toCharArray())
            if(c == '1') {
                cnt++;
            }
        System.out.println(cnt);
    }
}
