package com.lxj.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一等多情况
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random() * 1000));
                        System.out.println("No"+ finalI + "完成检查");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            };
            threadPool.submit(runnable);
        }
        System.out.println("等待5个人检查");
        countDownLatch.await();
        System.out.println("所有人完成了工作");
    }
}
