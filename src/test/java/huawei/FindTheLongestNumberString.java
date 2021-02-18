package huawei;

import java.util.Scanner;

/**
 * 在字符串中找出连续最长的数字串
 */
public class FindTheLongestNumberString {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input = sc.nextLine();
            String [] nums = input.split("[A-Za-z]+");
            int maxLength = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != ""){
                    if (nums[i].length() > maxLength){
                        maxLength = nums[i].length();
                    }

                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != ""){
                    if (maxLength == nums[i].length()){
                        System.out.print(nums[i]);
                    }
                }
            }
            System.out.print(","+maxLength);
            System.out.println();
        }
    }
}
