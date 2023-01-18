package com.lxj.leetcode.slidingwindow;

/**
 * @author Xingjing.Li
 * @since 2022/10/19
 */
public class FruitIntoBaskets904 {

    public int totalFruit(int[] fs) {
        int n = fs.length, ans = 0;
        int[] cnts = new int[n + 10];
        for (int i = 0, j = 0, tot = 0; i < n; i++) {
            if (++cnts[fs[i]] == 1) tot++;
            while (tot > 2) {
                if (--cnts[fs[j++]] == 0) tot--;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        FruitIntoBaskets904 solution = new FruitIntoBaskets904();
        int[] fruits = {1,2,1};
        solution.totalFruit(fruits);
    }
}
