package com.lxj.juc.cyclicbarrier;

import java.util.concurrent.*;

/**
 * @author Xingjing.Li
 * @since 3/21/2024
 */
public class CyclicBarrierDemo {

	CyclicBarrier barrier = new CyclicBarrier(5);
	CountDownLatch countDownLatch = new CountDownLatch(5);

	public void readFile() throws BrokenBarrierException, InterruptedException {
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		int i = 0;
//		for (int i = 0; i < 3; i++) {
			System.out.println("开始读取"+i+"文件");
			for (int j = 0; j < 5; j++) {
				final int no = j;
				int finalI = i;
				Runnable runnable = new Runnable() {
					@Override
					public void run() {
						try {
							String name = Thread.currentThread().getName();
							System.out.println("线程"+ no + "开始读取"+ finalI +"文件内容");
							Thread.sleep(1);
							System.out.println("线程"+ no + "读取"+ finalI +"文件内容完成");
							barrier.await();
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						} catch (BrokenBarrierException e) {
							throw new RuntimeException(e);
						}
					}
				};
				threadPool.submit(runnable);
			}
			System.out.println("读取文件完成");
//			System.out.println("reset");
//			barrier.reset();
//			threadPool.shutdown();
//		}

	}

	public void readFile2() throws BrokenBarrierException, InterruptedException {
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		int i = 0;
//		for (int i = 0; i < 3; i++) {
		System.out.println("开始读取"+i+"文件");
		for (int j = 0; j < 5; j++) {
			final int no = j;
			int finalI = i;
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						String name = Thread.currentThread().getName();
						System.out.println("线程"+ no + "开始读取"+ finalI +"文件内容");
						Thread.sleep(1);
						System.out.println("线程"+ no + "读取"+ finalI +"文件内容完成");
						countDownLatch.countDown();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			};
			threadPool.submit(runnable);
		}
		countDownLatch.await();
		System.out.println("读取文件完成");
//			System.out.println("reset");
//			barrier.reset();
//			threadPool.shutdown();
//		}

	}

	public static void main(String[] args) {
		CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo();
		try {
			cyclicBarrierDemo.readFile2();
		} catch (BrokenBarrierException e) {
			throw new RuntimeException(e);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
