package huawei;

import java.util.Scanner;

/**
 * 密码验证合格程序
 */
public class CheckPasswordProgram {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String pwd = sc.nextLine();
            if (checkLength(pwd)&& checkCharKinds(pwd)&& checkCharRepeat(pwd))
                System.out.println("OK");
            else
                System.out.println("NG");
        }

    }

    public static boolean checkCharRepeat(String password){
        for(int i=0 ;i<password.length()-2 ;i++){
            String substr1 =password.substring(i, i+3);
            String substring = password.substring(i + 1);
            if (substring.contains(substr1))
                return false;
        }
        return true;
    }

    public static boolean checkCharKinds(String pwd){
        char [] chars = pwd.toCharArray();
        int number=0, lowercase=0, uppercase=0, others=0;
        for(int i =0;i<chars.length;i++){
            if (chars[i]>='0'&& chars[i]<='9') {
                number=1;
                continue;
            }
            else if (chars[i]>='a'&& chars[i]<='z') {
                lowercase=1;
                continue;
            }
            else if (chars[i]>='A'&& chars[i]<='Z') {
                uppercase=1;
                continue;
            }else {
                others=1;
                continue;
            }
        }
        int total = number+lowercase+uppercase+others;
        return total>=3 ? true : false;
    }

    public static boolean checkLength(String pwd){
        if(pwd.length()> 8){
            return true;
        }
        return false;
    }
}
