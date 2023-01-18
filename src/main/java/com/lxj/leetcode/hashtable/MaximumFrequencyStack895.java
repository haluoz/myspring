package com.lxj.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分桶哈希表
 * @author Xingjing.Li
 * @since 2022/12/30
 */
public class MaximumFrequencyStack895 {
    //最大深度
    private int max = 0;
    //数字 频率
    private Map<Integer, Integer> count = new HashMap<>();
    //频率 列表
    private Map<Integer, List<Integer>> frequencyMap = new HashMap<>();

    public MaximumFrequencyStack895() {

    }

    public void push(int val) {
        count.put(val, count.getOrDefault(val, 0)+1);
        Integer frequency = count.get(val);
        frequencyMap.put(frequency, frequencyMap.getOrDefault(frequency, new ArrayList<>()));
        List<Integer> frequencyContentList = frequencyMap.get(frequency);
        frequencyContentList.add(val);
        max = Math.max(frequency, max);
    }

    public int pop() {
        List<Integer> frequencyContentList = frequencyMap.get(max);
        //移除栈顶元素
        Integer ans = frequencyContentList.remove(frequencyContentList.size() - 1);
        //维护count数量
        count.put(ans, count.get(ans) - 1);
        if (frequencyContentList.size() == 0) max--;
        return ans;
    }

    public static void main(String[] args) {
        MaximumFrequencyStack895 solution = new MaximumFrequencyStack895();
        solution.push(5); // The stack is [5]
        solution.push(7); // The stack is [5,7]
        solution.push(5); // The stack is [5,7,5]
        solution.push(7); // The stack is [5,7,5,7]
        solution.push(4); // The stack is [5,7,5,7,4]
        solution.push(5); // The stack is [5,7,5,7,4,5]
        solution.pop(); // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        solution.pop(); // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        solution.pop(); // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        solution.pop(); // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
    }
}
