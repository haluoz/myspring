package huawei;

import java.util.Scanner;

/**
 * 解析参数
 */
public class ParsingParameter {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            StringBuffer sb = new StringBuffer();
            String input = sc.nextLine();
            int count = 1;
            for(int i =0;i<input.length();i++){
                if(input.charAt(i) == ' ' || input.charAt(i) == '\"'){
                    if(input.charAt(i) == ' '){
                        sb.append("\r\n");
                        count++;
                    }else{
                        for(int j=i+1;j<input.length();j++){
                            if(input.charAt(j)=='\"'){
                                i=j;
                                break;
                            }
                            sb.append(input.charAt(j));
                        }
                    }
                }else{
                    sb.append(input.charAt(i));
                }
            }
            System.out.println(count);
            System.out.println(sb.toString());
        }

    }
}
