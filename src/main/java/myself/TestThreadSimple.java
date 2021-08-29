package myself;

/**
 * @description: 线程可见性测试
 * 线程可见性貌似和之前理解的不一样？
 * @author: suyue
 * @time: 2021/8/14 16:19
 */
public class TestThreadSimple {

    static Boolean running = true;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            while (running) {
                synchronized (running) {

                }
            }
        }).start();

        Thread.sleep(1000);

        new Thread(() -> running = false).start();

    }
}
