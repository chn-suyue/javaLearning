package myself;

import java.util.concurrent.TimeUnit;

/**
 * @description: 关于线程可见性的思考
 * @author: suyue
 * @time: 2021/8/14 0:23
 */
public class TestThread {


    public static void main(String[] args) throws InterruptedException {

        TestClass testClass = new TestClass(1);

        new Thread(() -> {
            Integer var = testClass.getVar();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread a start testClass.getVar(): " + testClass.getVar());
            System.out.println("thread a start var: " + var);
            while (var == 1) {

            }
            System.out.println("thread a end: " + var);
        }, "A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            testClass.setVar(2);
            System.out.println("thread b end testClass.getVar(): " + testClass.getVar());
        }, "B").start();

    }

}
