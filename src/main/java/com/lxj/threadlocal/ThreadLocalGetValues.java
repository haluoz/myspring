package com.lxj.threadlocal;

/**
 * @author Xingjing.Li
 * @since 2021/8/10
 */
public class ThreadLocalGetValues {
    private static ThreadLocal threadLocal = new ThreadLocal();
    private static int a = 7;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(a+2);
                System.out.println(Thread.currentThread().getName() + " "+threadLocal.get());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " "+threadLocal.get());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(a);
                System.out.println(Thread.currentThread().getName() + " "+ threadLocal.get());
                threadLocal.set(a-2);
                System.out.println(Thread.currentThread().getName() + " "+ threadLocal.get());
            }
        }).start();
    }
}
