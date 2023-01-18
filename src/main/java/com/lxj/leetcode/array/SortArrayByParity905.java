package com.lxj.leetcode.array;


import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Xingjing.Li
 * @since 2022/5/18
 */
public class SortArrayByParity905 {
    /**
     * 双端队列
     * @param nums
     * @return
     */
    public int[] sortArrayByParity(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        int [] retNums = null;
        for (int num : nums) {
            if (num % 2 == 0){
                deque.addFirst(num);
            }else{
                deque.addLast(num);
            }
        }
        if (!deque.isEmpty()){
            int size = deque.size();
            retNums = new int[size];
            for (int i = 0; i < size; i++) {
                retNums[i] = deque.poll();
            }
        }else {
            retNums = new int[]{};
        }
        return retNums;
    }

    /**
     * 原地交换
     * @param nums
     * @return
     */
    public int[] sortArrayByParity1(int[] nums){
        int n = nums.length;
        for (int i = 0, j = n - 1; i < j; i++) {
            if (nums[i] % 2 == 1) {
                int c = nums[j];
                nums[j--] = nums[i];
                nums[i--] = c;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        SortArrayByParity905 solution = new SortArrayByParity905();
        System.out.println(solution.sortArrayByParity1(new int[]{3, 1, 2, 4}));
//        String str = "/baseService/1234/3124";
//        String pattern = "\\/basService";
//        System.out.println(str.startsWith(pattern));
//        Pattern compile = Pattern.compile("/baseService");
//        Matcher m = compile.matcher(str);
//        System.out.println(m.find());
//        System.out.println("start():"+m.start());
//            System.out.println("end():"+m.end());
    }

    private static final String REGEX = "\\bimooc\\b";
    private static final String input = "imooc,imooc是慕课网的域名，网址是：www.imooc.com";

}
