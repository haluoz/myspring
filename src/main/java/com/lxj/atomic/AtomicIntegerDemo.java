package com.lxj.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo implements Runnable {
    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();

    public void increment(){
        ATOMIC_INTEGER.getAndIncrement();
    }

    private static volatile int basicCount = 0;

    public void incrementBasic(){
        basicCount++;
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerDemo demo = new AtomicIntegerDemo();
        Thread t1 = new Thread(demo);
        Thread t2 = new Thread(demo);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("atomic result is:"+ ATOMIC_INTEGER.get());
        System.out.println("non-atomic result is:"+ basicCount);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            increment();
            incrementBasic();
        }
    }
}
