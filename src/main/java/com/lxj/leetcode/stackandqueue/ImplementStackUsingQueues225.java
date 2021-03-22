package com.lxj.leetcode.stackandqueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。
 * 示例：
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 * 解释：
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // 返回 2
 * myStack.pop(); // 返回 2
 * myStack.empty(); // 返回 False
 */
public class ImplementStackUsingQueues225 {

    private Queue<Integer> inQueue;
    private Queue<Integer> backupQueue;

    public ImplementStackUsingQueues225() {
        inQueue = new ArrayDeque<>();
        backupQueue = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        inQueue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for (int i = 0; i <= inQueue.size() - 1 && inQueue.size() != 1; i++) {
            backupQueue.add(inQueue.poll());
        }
        int ret = inQueue.poll();
        for (int i = 0; i <= backupQueue.size() && backupQueue.size() != 0; i++) {
            inQueue.add(backupQueue.poll());
        }
        return ret;
    }

    /** Get the top element. */
    public int top() {
        int ret = pop();
        inQueue.add(ret);
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return inQueue.isEmpty() && backupQueue.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues225 myStack = new ImplementStackUsingQueues225();
        myStack.push(1);
        myStack.push(2);
//        myStack.push(3);
//        System.out.println(myStack.top());
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty()); // 返回 False
    }
}
