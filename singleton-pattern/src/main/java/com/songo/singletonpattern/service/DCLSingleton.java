package com.songo.singletonpattern.service;

import java.io.Serializable;

/**
 * @Author SonGo
 * @Create 2020/10/14 9:19
 * @Description 双检锁/双重校验锁（DCL，即 double-checked locking）
 * 单例模式三个主要特点：
 * 1、构造方法私有化；
 * 2、实例化的变量引用私有化；
 * 3、获取实例的方法共有。
 */
public class DCLSingleton implements Serializable {

    private static final long serialVersionUID = 6242241249985894658L;
    /**
     * volatile 作用：内存中可见 和 防止指令重排
     * 这里主要作用是防止指令重排
     */
    private volatile static DCLSingleton instance;

    private DCLSingleton() {
    }

    public static DCLSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLSingleton.class) {
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
    public void singletonFunction() {
        System.out.println("DCLSingleton test.");
    }
}
