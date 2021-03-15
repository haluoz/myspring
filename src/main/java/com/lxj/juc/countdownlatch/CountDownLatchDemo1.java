package com.lxj.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多等一情况
 */
public class CountDownLatchDemo1 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("准备完毕,等待发令枪");
                    try {
                        countDownLatch.await();
                        System.out.println("No"+finalI+"开始跑步了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            threadPool.submit(runnable);
        }
        Thread.sleep(5000);
        System.out.println("枪响，开始比赛");
        countDownLatch.countDown();
    }
}
