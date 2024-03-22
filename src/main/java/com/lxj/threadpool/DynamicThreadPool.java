package com.lxj.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @author Xingjing.Li
 * @since 3/20/2024
 */
public class DynamicThreadPool {

	public static void main(String[] args) {
		try {
			dynamicThreadPoolModification();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void dynamicThreadPoolModification() throws InterruptedException {
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
		for (int i = 0; i < 15; i++) {
			threadPoolExecutor.execute(new Runnable() {
				@Override
				public void run() {
					printThreadPoolStatus(threadPoolExecutor, "创建任务");
					try {
						Thread.sleep(5000);
						System.out.println(Thread.currentThread().getName()+"完成任务");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		printThreadPoolStatus(threadPoolExecutor, "改变前");
		threadPoolExecutor.setCorePoolSize(10);
		threadPoolExecutor.setMaximumPoolSize(10);
		printThreadPoolStatus(threadPoolExecutor, "改变后");
	}

	public static void printThreadPoolStatus(ThreadPoolExecutor executor, String name){
		BlockingQueue<Runnable> queue = executor.getQueue();
		System.out.println(Thread.currentThread().getName() + "-" + name+
				" core pool size: "+ executor.getCorePoolSize()+
				" active size: "+ executor.getActiveCount()+
				" maximum size: "+ executor.getMaximumPoolSize()+
				" activity: "+ divide(executor.getActiveCount(), executor.getMaximumPoolSize()) +
				" completion: "+ executor.getCompletedTaskCount()+
				" queue size: "+ queue.size()+ queue.remainingCapacity()+
				" current queue: "+ queue.size()+
				" remaining queue: "+ queue.remainingCapacity()+
				" queue usability: "+divide(queue.size(), queue.size()+ queue.remainingCapacity())
		);
	}

	private static String divide(int num1, int num2) {
		return String.format("%1.2f%%", Double.parseDouble(num1+"") / Double.parseDouble(num2+"")*100);
	}

}
