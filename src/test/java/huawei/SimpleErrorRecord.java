package huawei;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleErrorRecord {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> map = new LinkedHashMap<>();
        while(sc.hasNext()){
            String log = sc.nextLine();
            String []fileAndNum = log.split(" ");
            fileAndNum[0] = fileAndNum[0].substring(fileAndNum[0].lastIndexOf("\\")+1,fileAndNum[0].length());
            int length = fileAndNum[0].length();
            if (length > 16){
                fileAndNum[0] = fileAndNum[0].substring(length - 16,length);
            }
            log = fileAndNum[0] +" "+ fileAndNum[1];
            if(map.containsKey(log)){
                map.put(log,map.get(log)+1);
            }else{
                map.put(log,1);
            }
        }
        int cnt=0;
        for(Map.Entry<String,Integer> it:map.entrySet()){
            if(map.size()-cnt<=8){
                System.out.println(it.getKey()+" "+it.getValue());
            }
            cnt++;
        }
    }
}
