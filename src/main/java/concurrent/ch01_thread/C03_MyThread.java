package concurrent.ch01_thread;

/**
 * @description: 继承 Thread 类
 * @author: suyue
 * @time: 2020/9/28 21:26
 */
public class C03_MyThread extends Thread {
    public void run() {
        // ...
        System.out.println("myThread has done something...");
    }

//    public static void main(String[] args) {
//        MyThread mt = new MyThread();
//        mt.start();
//    }

    //Executor线程执行器
//    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < 5; i++) {
//            executorService.execute(new MyRunnable());
//        }
//        executorService.shutdown();
//    }

    //daemon守护线程
    public static void main(String[] args) {
        Thread thread = new Thread(new C01_MyRunnable());
        thread.setDaemon(true);
    }



}