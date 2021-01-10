package com.lxj.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 字符个数统计
 */
public class CountString {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        Map<Character,Object> map = new HashMap<>();
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(0<c &&c<127){
                map.put(c,null);
            }
        }
        System.out.println(map.keySet().size());
    }
}
