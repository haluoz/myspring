package huawei;

import java.security.Key;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 成绩排序
 */
public class SortScore {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int times = sc.nextInt();
            int order = sc.nextInt();
            String [] names = new String[times];
            int [] scores = new int[times];
            for(int i =0;i<times;i++){
                String name = sc.next();
                int score = sc.nextInt();
                names[i] = name;
                scores[i] = score;
            }
            if(order == 1){
                for(int i =0;i<times;i++){
                    for(int j =0;j<times-i-1;j++){
                        if(scores[j] > scores[j+1]){
                            int temp = scores[j];
                            scores[j] = scores[j+1];
                            scores[j+1] = temp;
                            String tmp = names[j];
                            names[j] = names[j+1];
                            names[j+1] = tmp;
                        }
                    }
                }
            }else{
                for(int i =0;i<times;i++){
                    for(int j =0;j<times-i-1;j++){
                        if(scores[j] < scores[j+1]){
                            int temp = scores[j];
                            scores[j] = scores[j+1];
                            scores[j+1] = temp;
                            String tmp = names[j];
                            names[j] = names[j+1];
                            names[j+1] = tmp;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<times;i++) {
                sb.append(names[i] + " ");
                sb.append(scores[i]);
                System.out.println(names[i] + " " + scores[i]);
            }
//               sb.deleteCharAt(sb.length()-1);
        }
    }
}
