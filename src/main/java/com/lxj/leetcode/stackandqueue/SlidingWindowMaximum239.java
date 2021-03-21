package com.lxj.leetcode.stackandqueue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * @author lee
 */
public class SlidingWindowMaximum239 {

    private class MyQueue{
        private Deque<Integer> deque = new LinkedList<>();
        // 每次弹出的时候，比较当前要弹出的数值是否等于队列出口元素的数值，如果相等则弹出。
        // 同时pop之前判断队列当前是否为空。
        void pop(int value) {
            if (!deque.isEmpty() && value == deque.getFirst()) {
                deque.removeFirst();
            }
        }
        // 如果push的数值大于入口元素的数值，那么就将队列后端的数值弹出，直到push的数值小于等于队列入口元素的数值为止。
        // 这样就保持了队列里的数值是单调从大到小的了。
        void push(int value) {
            while (!deque.isEmpty() && value > deque.getLast()) {
                deque.removeLast();
            }
            deque.addLast(value);

        }
        // 查询当前队列里的最大值 直接返回队列前端也就是front就可以了。
        int front() {
            return deque.getFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue queue = new MyQueue();
        ArrayList<Integer> result = new ArrayList<>();
        // 先将前k的元素放进队列
        for (int i = 0; i < k; i++) {
            queue.push(nums[i]);
        }
        // result 记录前k的元素的最大值
        result.add(queue.front());
        for (int i = k; i < nums.length; i++) {
            // 滑动窗口移除最前面元素
            queue.pop(nums[i - k]);
            // 滑动窗口前加入最后面的元素
            queue.push(nums[i]);
            // 记录对应的最大值
            result.add(queue.front());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        SlidingWindowMaximum239 solution = new SlidingWindowMaximum239();
        int [] nums ={1,3,-1,-3,5,3,6,7};
        int[] maxSlidingWindow = solution.maxSlidingWindow(nums, 3);
    }
}
