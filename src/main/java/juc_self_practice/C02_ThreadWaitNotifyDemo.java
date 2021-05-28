package juc_self_practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AirConditioner {
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            // 1、判断
            while (num > 0) {
                condition.await();//this.wait();
            }
            //2、干活
            num++;
            System.out.println(Thread.currentThread().getName() + ":" + num);
            //3、唤醒
            condition.signalAll();//this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {

        lock.lock();
        try {
            //1、判断
            while (num <= 0) {
                condition.await();//this.wait();
            }
            //2、干活
            num--;
            System.out.println(Thread.currentThread().getName() + ":" + num);
            //3、唤醒
            condition.signalAll();//this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    /*public synchronized void increment() throws InterruptedException {
        // 1、判断
        while (num>0) {
            this.wait();
        }
        //2、干活
        num++;
        System.out.println(Thread.currentThread().getName() + ":" + num);
        //3、唤醒
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        //1、判断
        while (num<=0) {
            this.wait();
        }
        //2、干活
        num--;
        System.out.println(Thread.currentThread().getName() + ":" + num);
        //3、唤醒
        this.notifyAll();
    }*/
}

/**
 * 题目：现在有两个线程，可以操作初始值为零的一个变量，
 * 实现一个线程对该变量加一，一个线程对该变量减一，
 * 实现交替，来10轮，变量初始值为0。
 * <p>
 * 1.    高内聚低耦合前提下，线程操作资源类
 * 2.    判断/干活/通知
 * 3.    多线程交互中，必须要防止多线程虚假唤醒(判断用while，不能用if)
 */
public class C02_ThreadWaitNotifyDemo {

    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airConditioner.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airConditioner.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airConditioner.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airConditioner.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();

    }

}
