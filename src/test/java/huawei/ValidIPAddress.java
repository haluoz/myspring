package huawei;

import java.util.Scanner;

/**
 * 合法IP
 */
public class ValidIPAddress {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            boolean flag = true;
            String ip = sc.nextLine();
            String [] nums = ip.split("\\.");
            for(int i =0;i<nums.length;i++){
                if(!valid(nums[i])){
                    System.out.println("NO");
                    flag= false;
                    break;
                }
            }
            if(flag){
                System.out.println("YES");
            }

        }
    }

    public static boolean valid(String str){
        if(str == ""){
            return false;
        }
        for(int i = 0;i<str.length();i++){
            if (str.charAt(i) > '9' || str.charAt(i) < '0'){
                return false;
            }
        }
        if(Integer.valueOf(str) > 255){
            return false;
        }
        return true;
    }
}
