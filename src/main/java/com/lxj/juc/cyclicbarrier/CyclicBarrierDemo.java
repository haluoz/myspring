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
		// 权限
		// 分为两部分 1功能权限控制 2数据权限控制
		// 1.请求写数据库 都数据库
		// 2.数据权限控制
		// 2.1 使用自定义 注解使用aop
		// 2.2 切入点 pointcut 通知 before advice
		// 3. 登录的时候 查询出当前角色的部门的人 写入redis
		// 4. 缓存的数据后不是动态变化
		// 5. 通过发送mq消息去刷新redis里的权限值
		// 分数同步bi 分表
		// 1.宽表 wide table
		// 2.全局唯一id 用美团的leaf
		// 3.sharding sharding key companyId
		// jxelExpression
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
