package concurrent.ch01_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: suyue
 * @time: 2020/10/1 19:13
 */
public class C04_InterruptExample {
    private static class MyThread1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            while (!interrupted()) {
                // ..
                System.out.println("Thread is ok");
            }
            System.out.println("Thread end");
        }
    }

//    public static void main(String[] args) throws InterruptedException {
//        Thread thread1 = new MyThread1();
//        thread1.start();
//        thread1.interrupt();
//        System.out.println("Main run");
//    }

//    public static void main(String[] args) throws InterruptedException {
//        Thread thread2 = new MyThread2();
//        thread2.start();
//        thread2.sleep(2000);
//        thread2.interrupt();
//    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdownNow();
        System.out.println("Main run");
    }

}
