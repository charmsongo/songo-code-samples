package com.songo.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author SonGo
 * @Create 2020/9/12 17:57
 * @Description
 */
public class SemaphoreDemo1 {
    //请求的数量
    private static int THREACOUNT = 550;

    public static void main(String[] args) {
        // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        Semaphore semaphore = new Semaphore(20);
        for (int i = 0; i < THREACOUNT; i++) {
            final int threadnum = i;
            // Lambda 表达式的运用
            threadPool.execute(() ->{
                try {
                    // 获取一个许可，所以可运行线程数量为20/1=20
                    semaphore.acquire();
                    test(threadnum);
                    // 释放一个许可
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
        System.out.println("finish");
    }

    private static void test(int threadnum) {
        try {
            // 模拟请求的耗时操作
            TimeUnit.SECONDS.sleep(1);
            System.out.println("threadnum:"+threadnum);
            // 模拟请求的耗时操作
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
