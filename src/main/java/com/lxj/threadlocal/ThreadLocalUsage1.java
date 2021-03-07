package com.lxj.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 30线程打印日期
 * @author Administrator
 */
public class ThreadLocalUsage1 {
    public String date(int seconds){
        Date date = new Date(1000 * seconds);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.format(date);
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalUsage1().date(finalI);
                    System.out.println(date);
                }
            }).start();
            Thread.sleep(100);
        }
    }
}
