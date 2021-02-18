package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 合并表记录
 */
public class CombineTableRecord {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        if(scanner.hasNext()){
            int num = scanner.nextInt();
            for(int i =0;i<num; i++){
                int key = scanner.nextInt();
                int value = scanner.nextInt();
                if (map.containsKey(key)){
                    map.put(key,map.get(key)+value);
                }else{
                    map.put(key,value);
                }
            }
        }
        map.forEach((key,val)->{
            System.out.println(key +" "+ val);
        });

    }
}
