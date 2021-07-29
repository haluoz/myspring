package com.lxj.leetcode.string;


import java.util.LinkedList;
import java.util.List;

public class ExcelSheetColumnTitle168 {
    private List<Integer> list;
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        String swap = swap(sb.toString());
        return swap;
    }

    public String swap(String str){
        char[] chars = str.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        LinkedList<Object> list = new LinkedList<>();
        list.add(1);
        list.remove(1);

        System.out.println(list.contains(1));
        ExcelSheetColumnTitle168 solution = new ExcelSheetColumnTitle168();
        System.out.println(solution.convertToTitle(28));
    }
}
