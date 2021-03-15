package com.lxj.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多等一情况
 */
public class CountDownLatchDemo2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(5);
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("准备完毕,等待发令枪");
                    try {
                        begin.await();
                        System.out.println("No"+finalI+"开始跑步了");
                        Thread.sleep((long) (Math.random()*10000));
                        System.out.println("No"+finalI+"到终点了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        end.countDown();
                    }
                }
            };
            threadPool.submit(runnable);
        }
        Thread.sleep(5000);
        System.out.println("枪响，开始比赛");
        begin.countDown();
        end.await();
        System.out.println("比赛结束");
    }
}
