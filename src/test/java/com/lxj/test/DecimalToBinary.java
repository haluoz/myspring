package com.lxj.test;

import java.util.*;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int num = scanner.nextInt();
//        String binary = Integer.toBinaryString(num);
//        System.out.println(binary);
//        String str = String.valueOf(num);
//        for (int i = str.length()-1; i >=0 ; i--) {
//            System.out.print(str.charAt(i));
//        }
//        String str = scanner.next();
//        System.out.println(str);
//        String sentences[] = str.split(" ");
//        StringBuilder sb =new StringBuilder();
//        for(int i = sentences.length -1; i>=0;i--){
//            sb.append(sentences[i]);
//            sb.append(" ");
//        }
//        System.out.println(sb);
//        int total = scanner.nextInt();
//        while(scanner.hasNext()){
//            String [] words = new String[total];
//            for(int i = 0; i< total; i++){
//                words[i] = scanner.next();
//            }
//            Arrays.sort(words);
//            for(int i =0;i<words.length;i++){
//                System.out.println(words[i]);
//            }
//        }

//        while (in.hasNextInt()) {
//            int number = in.nextInt();
//            if (number == 0) break;
//            int result = calculate(number);
//            System.out.println(result);
//        }
//        char c ='A';
//        System.out.println((char)(c+32));
//        char c1 ='a';
//        System.out.println((char)(c1-32));
//        while(in.hasNext()){
//            String str = in.next();
//            while(str.length()>8){
//                String newStr = str.substring(0,8);
//                System.out.println(newStr);
//                str = str.substring(8);
//            }
//            int temp = 8 -str.length();
//            for(int i =0;i<temp;i++){
//                str += "0";
//            }
//            System.out.println(str);
//        }
//        String str =in.nextLine();
//        String words[] = str.split(" ");
//        System.out.println(words[words.length-1].toCharArray().length);
//        Set<String> set = new HashSet<>();
//        set.add("1");
//        set.add("2");
//        set.add("3");
//        set.add("4");
//        set.add("5");
//        System.out.println(set.toString());
//        //这里后续用有序的list处理即可，因为流中进行了倒序处理，收集成set后会重排
//        List<String> collect = set.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//        System.out.println(Integer.parseInt("0xAA".replaceAll("x",""),16));
//        System.out.println(Integer.parseInt("00010100".replaceAll("x",""),2));

//        String s1 = new String("aaa");
//        String s2 = new String("aaa");
//        System.out.println(s1.equals(s2));

//        String str1 = "通话";
//        String str2 = "重地";
//        System.out.println(String.format("str1：%d | str2：%d",  str1.hashCode(),str2.hashCode()));
//        System.out.println(str1.equals(str2));

    }

    public static int calculate(int number){
        int bottoms = 0;
        while (number >= 3) {
            //可以换可乐的瓶数
            bottoms = bottoms + number/3;
            //空瓶子数量
            number = number%3 + number/3;
        }
        //借一瓶可乐
        if (number == 2) {
            bottoms++;
        }
        return bottoms;
    }
}
