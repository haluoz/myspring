package com.lxj.threadpool;

import java.util.concurrent.*;

/**
 * @author Xingjing.Li
 * @since 2/18/2024
 */
public class CreateThread {
    public static void main(String[] args) {
		ThreadPoolExecutor executor =
				new ThreadPoolExecutor(
						1,
						2,
						0L,
						TimeUnit.MILLISECONDS,
						new LinkedBlockingQueue<>(1),
						new ThreadPoolExecutor.CallerRunsPolicy());

		// Submit 10 tasks to the executor
		for (int i = 1; i <= 10; i++) {
			final int taskId = i;
			executor.submit(() -> {
				System.out.println("Executing Task " + taskId + " on Thread " + Thread.currentThread().getName());
				try {
					// Simulate some work
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}

		// Shutdown the executor
		executor.shutdown();
	}
}
