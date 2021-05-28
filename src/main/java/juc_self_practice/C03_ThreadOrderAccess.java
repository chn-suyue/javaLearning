package juc_self_practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource {

    private int num = 1; //1:A, 2:B, 3:C

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            //1、判断
            while (num != 1) {
                condition1.await();
            }
            //2、干活
            System.out.println(Thread.currentThread().getName() + ":5");
            //3、通知，并修改标志位
            num = 2;
            condition2.signal();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            //1、判断
            while (num != 2) {
                condition2.await();
            }
            //2、干活
            System.out.println(Thread.currentThread().getName() + ":10");
            //3、通知，并修改标志位
            num = 3;
            condition3.signal();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            //1、判断
            while (num != 3) {
                condition3.await();
            }
            //2、干活
            System.out.println(Thread.currentThread().getName() + ":15");
            //3、通知，并修改标志位
            num = 1;
            condition1.signal();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 多线程之间按顺序调用，实现A ->B ->C
 * 三个线程启动，要求如下：
 * <p>
 * AA打印5次，BB打印10次，CC打印15次
 * 接着
 * AA打印5次，BB打印10次，CC打印15次
 * ..........来10轮
 * <p>
 * 1.    高内聚前提下，线程操作资源类
 * 2.    判断/干活/通知
 * 3.    多线程交互中，必须要防止多线程虚假唤醒(判断用while，不能用if)
 * 4.    标志位
 */
public class C03_ThreadOrderAccess {

    public static void main(String[] args) {

        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print5();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print10();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print15();
            }
        }, "C").start();
    }

}
