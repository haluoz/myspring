package com.lxj.leetcode.datastructure;

/**
 * @author Xingjing.Li
 * @since 2021/10/26
 */
public class DesignCircularQueue622 {

    private Integer[] data;
    private int size, head, tail;
    private int capacity;

    public DesignCircularQueue622(int k) {
        data = new Integer[k];
        size = 0;
        tail = 0;
        head = 0;
        capacity = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        int position = (head * size) % capacity;
        data[position] = value;
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : data[head];
    }

    public int Rear() {
        if (isEmpty()){
            return -1;
        } else {
            int tail = (head + size -1) % capacity;
            return data[tail];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return capacity == size;
    }

    public static void main(String[] args) {
        //["enQueue","Rear","Front","deQueue","Front","deQueue","Front","enQueue","enQueue","enQueue","enQueue"]
        DesignCircularQueue622 myCircularQueue = new DesignCircularQueue622(3);
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.Rear();
        myCircularQueue.Front();
        myCircularQueue.deQueue();
        myCircularQueue.Front();
        myCircularQueue.deQueue();
        myCircularQueue.Front();
        myCircularQueue.enQueue(4);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);
    }
}
