package com.lxj.juc.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    void method1(){
        lock.lock();
        try {
            System.out.println("条件不满足，开始await");
            condition.await();
            System.out.println("条件满足了，开始执行后续的任务");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void method2(){
        lock.lock();
        try {
            System.out.println("准备工作完成，准备唤醒其他线程");
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionDemo conditionDemo = new ConditionDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    conditionDemo.method2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        conditionDemo.method1();
    }
}
