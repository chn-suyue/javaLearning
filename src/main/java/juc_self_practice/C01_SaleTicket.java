package juc_self_practice;

import java.util.concurrent.locks.ReentrantLock;

class Ticket {

    private int num = 30;
    private ReentrantLock lock = new ReentrantLock();

    public void saleTicket() {
        lock.lock();
        try {
            if (num > 0) {
                num--;
                System.out.println("线程" + Thread.currentThread().getName() + "抢到一张票，剩余：" + num);
            } else {
                System.out.println("票已卖完，剩余票数：" + num);
            }
        } finally {
            lock.unlock();
        }
    }

}

/**
 * 多线程编程企业级套路+模板
 * <p>
 * 1、在高内聚低耦合的前提下， 线程     操作（对外暴露操作方法）     资源类
 */
public class C01_SaleTicket {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.saleTicket();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.saleTicket();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.saleTicket();
            }
        }, "C").start();

    }

}
