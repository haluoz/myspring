package com.lxj.algorithm.queue;

public class LoopQueue<E> implements Queue<E> {
    private E [] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        if((tail+1) % data.length == front){
            resize(getCapacity() *2);
        }
        data[tail]  = e;
        tail = (tail+1)%data.length;
        size++;
    }

    private void resize(int capacity) {
        E [] newData = (E[]) new Object[capacity+1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front+i)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("cannot dequeue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front +1) % data.length;
        size--;
        if (size == getCapacity() /4 && getCapacity() /2 != 0){
            resize(getCapacity() /2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new RuntimeException("queue empty");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity(){
        return data.length-1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoopQueue:");
        sb.append('[');
        for (int i = front; i != tail; i=(i+1) % data.length) {
            sb.append(data[i]);
            if ((i+1)%data.length != tail){
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        try {
            for (int i = 0; i < 10; i++) {
                queue.enqueue(i);
                System.out.println(queue.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
