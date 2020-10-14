package com.songo.singletonpattern.service;

import java.io.Serializable;

/**
 * @Author SonGo
 * @Create 2020/10/14 9:19
 * @Description 登记式/静态内部类
 */
public class SingletonPattern2 implements Serializable {

    private static class SingletonHolder {
        private static final SingletonPattern2 INSTANCE = new SingletonPattern2();
    }
    private SingletonPattern2 (){}
    public static final SingletonPattern2 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

