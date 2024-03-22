package com.lxj.threadpool;

import java.util.Comparator;

public class PriorityTask implements Runnable, Comparable<PriorityTask> {

	private int priority;

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"执行任务, 优先级:"+priority);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"完成任务, 优先级:"+priority);
	}


	public PriorityTask(int priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public int compareTo(PriorityTask o) {
		return  o.priority - priority;
	}
}
