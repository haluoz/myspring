package com.lxj.juc.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    static Semaphore semaphore = new Semaphore(3, true);

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 100; i++) {
            threadPool.submit(new Task());
        }
        threadPool.shutdown();
    }

    static class Task implements Runnable{

        @Override
        public void run() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了许可证");
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+"释放了许可证");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }

        }
    }
}
