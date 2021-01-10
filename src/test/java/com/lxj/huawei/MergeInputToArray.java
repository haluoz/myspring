package com.lxj.huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 整形数组合并
 * 将两个整型数组按照升序合并，并且过滤掉重复数组元素。
 */
public class MergeInputToArray {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            Set<Integer> set = new HashSet<>();
            int num1 = sc.nextInt();
            for(int i =0; i<num1;i++){
                set.add(sc.nextInt());
            }
            int num2 = sc.nextInt();
            for(int i =0; i<num2;i++){
                set.add(sc.nextInt());
            }
            int [] nums = new int[set.size()];
            int index = 0;
            for(Integer i: set){
                nums[index] = i;
                index++;
            }
            Arrays.sort(nums);
//             String res = "";
//             for (int i = 0; i < nums.length; i++){
//                 res += nums[i];
//             }
//             System.out.println(res);
            for (int i = 0; i < nums.length; i++){
                System.out.print(nums[i]);
            }
            System.out.println();
        }
    }
}
