package com.lxj.leetcode.array;

/**
 * @author Xingjing.Li
 * @since 2021/7/26
 */
public class Offer53 {
    public int search(int[] nums, int target) {
        int count = 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (target < nums[mid]) {
                r = mid - 1;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else if (target == nums[mid]) {
                count++;
            }
        }
        return count;
    }

    public int search1(int[] nums, int t) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= t) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int ans = 0;
        while (l < n && nums[l] == t && l++ >= 0) {
            ans++;
        }
        return ans;
    }

    public int search2(int[] nums, int t) {
        int n = nums.length;
        if (n == 0) return 0;
        int a = -1, b = -1;

        // 二分出左边界
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= t) r = mid;
            else l = mid + 1;
        }
        if (nums[r] != t) return 0;
        a = r;

        // 二分出右边界
        l = 0; r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= t) l = mid;
            else r = mid - 1;
        }
        if (nums[r] != t) return 0;
        b = r;

        return b - a + 1;
    }

    public static void main(String[] args) {
        Offer53 solution = new Offer53();
        int[] ints = {5, 7, 7, 8, 8, 10};
        System.out.println(solution.search1(ints, 8));
    }
}
