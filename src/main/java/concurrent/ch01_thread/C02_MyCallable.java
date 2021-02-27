package concurrent.ch01_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description: 实现 Callable 接口
 * 与 Runnable 相比，Callable 可以有返回值，返回值通过 FutureTask 进行封装。
 * @author: suyue
 * @time: 2020/9/28 21:20
 */
public class C02_MyCallable implements Callable<Integer> {
    @Override
    public Integer call() {
        return 123;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        C02_MyCallable mc = new C02_MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
    }
}
