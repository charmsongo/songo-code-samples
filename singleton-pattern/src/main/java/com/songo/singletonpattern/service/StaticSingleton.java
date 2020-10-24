package com.songo.singletonpattern.service;

import java.io.Serializable;

/**
 * @Author SonGo
 * @Create 2020/10/14 9:19
 * @Description 登记式/静态内部类
 */
public class StaticSingleton implements Serializable {

    private static final long serialVersionUID = 5537012394799626447L;

    private static class SingletonHolder {
        private static final StaticSingleton INSTANCE = new StaticSingleton();
    }
    private StaticSingleton(){}
    public static final StaticSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void singletonFunction() {
        System.out.println("StaticSingleton test.");
    }
}

