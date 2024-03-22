package com.lxj.threadpool;

import java.util.Comparator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Xingjing.Li
 * @since 3/20/2024
 */
public class PriorityThreadPool {
	public static void main(String[] args) {
		ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
		PriorityBlockingQueue<Runnable> blockingQueue = new PriorityBlockingQueue<>(10, new Comparator<Runnable>() {
			@Override
			public int compare(Runnable o1, Runnable o2) {
				if (o1 instanceof PriorityTask && o2 instanceof PriorityTask){
					PriorityTask task1 = (PriorityTask) o1;
					PriorityTask task2 = (PriorityTask) o2;
					return task2.getPriority() - task1.getPriority();
				}
				return 0;
			}
		});
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, blockingQueue);
		threadPoolExecutor.execute(new PriorityTask(1));
		threadPoolExecutor.execute(new PriorityTask(20));
		threadPoolExecutor.execute(new PriorityTask(2));
		threadPoolExecutor.execute(new PriorityTask(10));
	}


}

