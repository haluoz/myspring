package com.lxj.threadlocal;

import javax.lang.model.element.VariableElement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1000线程打印日期
 * 放入threadlocal，给每个线程分配自己的dateformat对象，保证线程安全，高效利用内存
 * @author Administrator
 */
public class ThreadLocalUsage2 {

    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public String date(int seconds){
        Date date = new Date(1000 * seconds);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat simpleDateFormat = ThreadSafeFormatter.threadLocal.get();
        return simpleDateFormat .format(date);
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalUsage1().date(finalI);
                    System.out.println(date);
                }
            });
        }
        threadPool.shutdown();
    }
}

class ThreadSafeFormatter{
    public static ThreadLocal<SimpleDateFormat> threadLocal =  new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
    };

}
