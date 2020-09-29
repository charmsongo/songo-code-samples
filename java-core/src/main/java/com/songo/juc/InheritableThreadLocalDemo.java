package com.songo.juc;

import java.util.UUID;

/**
 * @Author SonGo
 * @Create 2020/9/10 20:12
 * @Description
 */
public class InheritableThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        InheritableThreadLocal<Object> inheritableThreadLocal = new InheritableThreadLocal<>();
        threadLocal.set("父类数据：threadLocal");
        inheritableThreadLocal.set("父类数据：inheritableThreadLocal");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程取父线程数据threadLocal：" + threadLocal.get());
                System.out.println("inheritableThreadLocal：" + inheritableThreadLocal.get());
            }
        }).start();

        System.out.println(UUID.randomUUID().toString().replace("-",""));
        //MDC.put();
    }
}
