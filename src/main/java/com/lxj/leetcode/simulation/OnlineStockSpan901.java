package com.lxj.leetcode.simulation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Xingjing.Li
 * @since 2022/10/21
 */
public class OnlineStockSpan901 {
//    List<Integer> list = null;
    Deque<int[]> deque = null;
    int cur = 0;
    public OnlineStockSpan901() {
//        list = new ArrayList<>();
        deque = new ArrayDeque<>();
    }

    public int next(int price) {
        while (!deque.isEmpty() && deque.peekLast()[1] <= price){
            deque.pollLast();
        }
        int prev = deque.isEmpty() ? -1 : deque.peekLast()[0];
        int ans = cur - prev;
        deque.offerLast(new int[]{cur++, price});
        return ans;
    }

//    public int next(int price) {
//        int ans = 0;
//        list.add(price);
//        for (int i = list.size() - 1; i >= 0; i--) {
//            if (list.get(i) <= price){
//                ans++;
//            }else{
//                break;
//            }
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        OnlineStockSpan901 solution = new OnlineStockSpan901();
        int [] prices = {100, 80, 60, 70, 60, 75, 85};
        for (int price : prices) {
            System.out.println(solution.next(price));
        }
    }
}
