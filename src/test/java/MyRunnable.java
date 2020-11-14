public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is:" + Thread.currentThread().getName());
    }
}
