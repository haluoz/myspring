package com.lxj.leetcode.array;

/**
 * @author Xingjing.Li
 * @since 2021/10/18
 */
public class MountainArrayOffer69 {

    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 1, r = n - 1;
        while (l < r) {
            // 加一处理无限循环的问题
            int mid = l + r + 1  >> 1;
            if (arr[mid - 1] < arr[mid]) l = mid;
            else r = mid - 1;
        }
        return r;
    }

    public static void main(String[] args) {
        MountainArrayOffer69 solution = new MountainArrayOffer69();
//        solution.peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19});
        solution.peakIndexInMountainArray(new int[]{0,1,2,0});
    }
}
