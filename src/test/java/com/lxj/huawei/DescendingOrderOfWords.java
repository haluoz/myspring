package com.lxj.huawei;

import java.util.Scanner;
/**
 * 单词倒排
 */
public class DescendingOrderOfWords {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] sp = sc.nextLine().split("[^a-zA-Z]+");
        StringBuilder sb = new StringBuilder();
        for (int i = sp.length - 1; i >= 0; i--)
            sb.append(sp[i] + " ");
        System.out.println(sb.toString().trim());
        sc.close();
    }
}
