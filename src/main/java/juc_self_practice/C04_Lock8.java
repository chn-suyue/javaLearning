package juc_self_practice;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Phone {

    private static ReentrantLock lock = new ReentrantLock();

    /*public static synchronized void sendEmail() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("######send email");
    }

    public synchronized void sendQQ() {
        System.out.println("######send QQ");
    }*/

    public void hello() {
        System.out.println("######hello");
    }

    public static void sendEmail() {
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(4);
            System.out.println("######send email");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void sendQQ() {
        lock.lock();
        try {
            System.out.println("######send QQ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

/**
 * 题目：多线程8锁
 * 1. 标准访问 先打印邮件还是QQ？邮件（线程sleep（100），不然不一定）
 * 2. 邮件方法暂停4s钟，先打印邮件还是QQ？邮件
 * 3. 新增一个普通方法hello（），先打印hello还是邮件？hello
 * 4. 两部手机，请问先打印邮件还是QQ？QQ (lock.lock()为邮件)
 * 5. 两个静态同步方法，先打印邮件还是QQ？邮件
 * 6. 两个静态同步方法,两部手机，先打印邮件还是QQ？邮件
 * 7. 一个静态同步方法，一个普通同步方法,一部手机，先打印邮件还是QQ？QQ (lock.lock()为邮件)
 * 8. 一个静态同步方法，一个普通同步方法,两部手机，先打印邮件还是QQ？QQ (lock.lock()为邮件)
 */
public class C04_Lock8 {

    public static void main(String[] args) throws InterruptedException {

        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            phone.sendEmail();
        }, "A").start();
        Thread.sleep(100);
        new Thread(() -> {
            phone.sendQQ();
//            phone.hello();
//            phone2.sendQQ();
        }, "B").start();
    }

}
