package com.lxj.leetcode.greedy;

import java.util.Arrays;

/**
 * 输入: children = [1,2], cookies = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 * @author Administrator
 */
public class AssignCookie455 {
    public static int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);
        int child = 0, cookie = 0;
        while(child < children.length && cookie < cookies.length){
            if(children[child] <= cookies[cookie]){
                child++;
            }
            cookie++;
        }
        return child;
    }

    public static void main(String[] args) {
        int [] children = {1,2};
        int [] cookies = {1,2,3};
        findContentChildren(children, cookies);
    }
}
