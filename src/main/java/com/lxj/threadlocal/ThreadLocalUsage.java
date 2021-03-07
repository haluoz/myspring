package com.lxj.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2线程打印日期
 * @author Administrator
 */
public class ThreadLocalUsage {
    public String date(int seconds){
        Date date = new Date(1000 * seconds);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.format(date);
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalUsage().date(10);
                System.out.println(date);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalUsage().date(1007);
                System.out.println(date);
            }
        }).start();
    }
}
