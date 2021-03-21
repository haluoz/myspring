package com.lxj.leetcode.stackandqueue;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * @author lee
 */
public class TopKFrequentElements347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 要统计元素出现频率
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        // 定义一个小顶堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (priorityQueue.size() == k){
                if (priorityQueue.peek()[1] < count){
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{num,count});
                }
            }else {
                priorityQueue.offer(new int[]{num,count});
            }
        }
        int [] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = priorityQueue.poll()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements347 solution = new TopKFrequentElements347();
        int [] nums = {3,3,3,3,2,2,1,1,1,4,4,4,4,4,4};
        solution.topKFrequent(nums,2);
    }
}
