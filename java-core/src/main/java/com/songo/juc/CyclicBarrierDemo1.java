package com.songo.juc;

import java.util.concurrent.*;

/**
 * @Author SonGo
 * @Create 2020/9/13 9:59
 * @Description
 */
public class CyclicBarrierDemo1 {
    private static int threadCount = 550;
    private static final CyclicBarrier cyclicbarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < threadCount; i++) {
            final int threadnum = i;
            TimeUnit.SECONDS.sleep(1);
            threadPool.execute(()->{
                test(threadnum);
            });
            
        }
        threadPool.shutdown();
    }

    private static void test(int threadnum) {
        System.out.println("threadnum:" + threadnum + " is ready");
        try {
            cyclicbarrier.await(60, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("-----CyclicBarrierException------");
        }
        System.out.println("threadnum:" + threadnum + " is finish");
    }
}
