package com.lxj.leetcode.thread;

public class FizzBuzzMultithreaded1195 {
    private static int i = 1;
    private static int n = 15;

    public static void main(String[] args) {
        new Thread(new printFizz()).start();
        new Thread(new printBuzz()).start();
        new Thread(new printFizzBuzz()).start();
        new Thread(new printNumber()).start();
    }

    static class printFizz implements Runnable{
        @Override
        public void run() {
            while(i <= n){
                if(i % 3 == 0 && i % 5 != 0){
                    System.out.println("Fizz");
                    i++;
                }
            }
        }
    }

    static class printBuzz implements Runnable{
        @Override
        public void run() {
            while(i <= n) {
                if (i % 5 == 0 && i % 3 != 0) {
                    System.out.println("Buzz");
                    i++;
                }
            }
        }
    }

    static class printFizzBuzz implements Runnable{
        @Override
        public void run() {
            while(i <= n) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                    i++;
                }
            }
        }
    }

    static class printNumber implements Runnable{
        @Override
        public void run() {
            while(i <= n) {
                if (i % 3 != 0 && i % 5 != 0) {
                    System.out.println(i);
                    i++;
                }
            }
        }
    }
}


