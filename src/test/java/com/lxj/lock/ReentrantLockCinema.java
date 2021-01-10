package com.lxj.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockCinema {
    private static ReentrantReadWriteLock reentrantReadWriteLockLock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLockLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLockLock.writeLock();

    private static void read(){
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到读锁，正在读取");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放读锁");
            readLock.unlock();
        }
    }

    private static void write(){
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到写锁，正在写入");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放写锁");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
//        new Thread(() -> read(),"thread1").start();
//        new Thread(() -> read(),"thread2").start();
//        new Thread(() -> write(),"thread3").start();
//        new Thread(() -> write(),"thread4").start();
    }
}
