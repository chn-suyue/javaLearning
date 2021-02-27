package concurrent.ch01_thread;

/**
 * 有三种使用线程的方法：
 * 实现 Runnable 接口；
 * 实现 Callable 接口；
 * 继承 Thread 类。
 */
public class C01_MyRunnable implements Runnable {
    @Override
    public void run() {
        // ...
        System.out.println("myRunnable has done something...");
    }
    
    public static void main(String[] args) {
        C01_MyRunnable instance = new C01_MyRunnable();
        long time = System.currentTimeMillis();
        System.out.println("the main thread name:"+Thread.currentThread().getName()+",the same time:"+time);
        System.out.println("main thread id:"+Thread.currentThread().getId());
        Thread thread = new Thread(instance);
        thread.start();
        System.out.println("name:"+thread.getName()+",the same time:"+time);
        System.out.println("id:"+thread.getId());
    }
}
