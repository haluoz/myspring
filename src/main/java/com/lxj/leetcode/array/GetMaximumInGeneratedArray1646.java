package com.lxj.leetcode.array;

/**
 * @author Xingjing.Li
 * @since 2021/8/27
 */
public class GetMaximumInGeneratedArray1646 {

    public int getMaximumGenerated(int n) {
        int [] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        for(int i = 0; i< n; i++){
            if (2 * i <= n){
                nums[2 * i] = nums[i];
            }
            if (2 * i + 1 <= n){
                nums[2 * i + 1] = nums[i] + nums[i + 1];
            }
        }
        int max = 0;
        for(int i : nums){
            max = Math.max(i, max);
        }
        return max;
    }

    public static void main(String[] args) {
        GetMaximumInGeneratedArray1646 solution = new GetMaximumInGeneratedArray1646();
        System.out.println(solution.getMaximumGenerated(7));
    }
}
