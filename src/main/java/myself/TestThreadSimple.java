package myself;

/**
 * @description: 线程可见性测试
 *                  线程可见性貌似和之前理解的不一样？
 * @author: suyue
 * @time: 2021/8/14 16:19
 */
public class TestThreadSimple {

    private volatile static boolean running = true;

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {

                }
                System.out.println("thread a finished...");
            }
        }, "A").start();

        Thread.sleep(100);

        new Thread(new Runnable() {
            @Override
            public void run() {
                running = false;
                System.out.println("thread b finished...");
            }
        }, "B").start();

    }

}
