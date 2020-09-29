package com.songo.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author SonGo
 * @Create 2020/9/13 9:36
 * @Description CountDownLatch 使用方法示例
 */
public class CountDownLauthDemo1 {
        private static int threadCount = 550;

        public static void main(String[] args) throws InterruptedException {
                // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
                ExecutorService threadPool = Executors.newFixedThreadPool(300);
                CountDownLatch downLatch = new CountDownLatch(threadCount);
                for (int i = 0; i < threadCount; i++) {
                        final int threadnum = i;
                        threadPool.execute(()->{
                                try {
                                        test(threadnum);
                                } catch (InterruptedException e) {
                                        e.printStackTrace();
                                }finally {
                                        // 表示一个请求已经被完成
                                        downLatch.countDown();
                                }
                        });
                }
                downLatch.await();
                threadPool.shutdown();
                System.out.println("finish");
        }

        private static void test(int threadnum) throws InterruptedException {
                // 模拟请求的耗时操作
                TimeUnit.SECONDS.sleep(1);
                System.out.println("threadnum:" + threadnum);
                // 模拟请求的耗时操作
                TimeUnit.SECONDS.sleep(1);
        }
}
