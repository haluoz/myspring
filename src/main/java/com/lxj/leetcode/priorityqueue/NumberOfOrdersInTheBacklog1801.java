package com.lxj.leetcode.priorityqueue;

import com.lxj.algorithm.queue.PriorityQueue;

/**
 * @author Xingjing.Li
 * @since 2023/1/3
 */
public class NumberOfOrdersInTheBacklog1801 {

    public int getNumberOfBacklogOrders(int[][] orders) {
        //price, amount, orderType
        //0 buy, 1 sell
        int n = orders.length;
        PriorityQueue<Integer> buy = new PriorityQueue<>();
        PriorityQueue<Integer> sell = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int type = orders[i][2];
            int amount = orders[i][1];
            int price = orders[i][0];
            for (int j = 0; j < amount; j++) {
                if (type == 0){
                    buy.enqueue(price);
                    while (!sell.isEmpty() && sell.getFront() <= price){
                        buy.dequeue();
                        sell.dequeue();
                    }
                } else if (type == 1) {
                    sell.enqueue(price);
                    while (!buy.isEmpty() && buy.getFront() >= price){
                        sell.dequeue();
                        buy.dequeue();
                    }
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        NumberOfOrdersInTheBacklog1801 solution = new NumberOfOrdersInTheBacklog1801();
        int [][] orders = {{10,5,0}, {15, 2 ,1}, {25,1,1}, {30, 4, 0}};
        solution.getNumberOfBacklogOrders(orders);
    }
}
