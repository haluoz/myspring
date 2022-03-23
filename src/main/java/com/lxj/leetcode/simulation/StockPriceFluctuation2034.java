package com.lxj.leetcode.simulation;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Xingjing.Li
 * @since 2022/1/24
 */
public class StockPriceFluctuation2034 {
    Map<Integer, Integer> map = new HashMap<>();
    TreeMap<Integer, Integer> timestamp = new TreeMap<>();
    int cur;
    public StockPriceFluctuation2034() {

    }

    public void update(int timestamp, int price) {
        cur = Math.max(cur, timestamp);
        if (map.containsKey(timestamp)) {
            int old = map.get(timestamp);
            int cnt = this.timestamp.get(old);
            if (cnt == 1) this.timestamp.remove(old);
            else this.timestamp.put(old, cnt - 1);
        }
        map.put(timestamp, price);
        this.timestamp.put(price, this.timestamp.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return map.get(cur);
    }

    public int maximum() {
        return timestamp.lastKey();
    }

    public int minimum() {
        return timestamp.firstKey();
    }

    public static void main(String[] args) {
        StockPriceFluctuation2034 solution = new StockPriceFluctuation2034();
        solution.update(1, 10);
        solution.update(2, 5);
        System.out.println(solution.current());
        System.out.println(solution.maximum());
        solution.update(1, 3);
        System.out.println(solution.maximum());
        solution.update(1, 3);
        System.out.println(solution.minimum());
    }
}
