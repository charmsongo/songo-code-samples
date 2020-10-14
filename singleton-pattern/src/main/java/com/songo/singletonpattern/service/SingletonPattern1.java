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
public class SingletonPattern1 implements Serializable {

    private static final long serialVersionUID = 6242241249985894658L;
    /**
     * volatile 作用：内存中可见 和 防止指令重排，这里主要是指令重排
     */
    private volatile static SingletonPattern1 instance;

    private SingletonPattern1() {
    }

    public static SingletonPattern1 getInstance() {
        if (instance == null) {
            synchronized (SingletonPattern1.class) {
                if (instance == null) {
                    instance = new SingletonPattern1();
                }
            }
        }
        return instance;
    }
    public void SingletonFunction() {
        System.out.println("SingletonPattern1 test.");
    }
}
