package com.songo.juc;

import java.util.concurrent.*;

/**
 * @Author SonGo
 * @Create 2020/9/13 10:13
 * @Description 新建 CyclicBarrier 的时候指定一个 Runnable
 */
public class CyclicBarrierDemo2 {
    private static final int threadCount = 550;

    private static final CyclicBarrier cyclicbarrier = new CyclicBarrier(5, ()->{
        System.out.println("达到5条后优先执行这条语句");
    });

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < threadCount; i++) {
            final int threadnum = i;
            TimeUnit.SECONDS.sleep(1);

            threadPool.execute(()->{
                try {
                    test(threadnum);
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
        System.out.println("threadPool finish");
    }

    private static void test(int threadnum) throws BrokenBarrierException, InterruptedException {
        System.out.println("threadnum:" + threadnum + " is ready");
        cyclicbarrier.await();
        System.out.println("threadnum:" + threadnum + " is finish");
    }
}
