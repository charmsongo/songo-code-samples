package com.songo.singletonpattern.service;

/**
 * @Author SonGo
 * @Create 2020/10/14 10:02
 * @Description 枚举单例模式
 */
public enum SingletonEnum {
    INSTANCE;

    public void doSomething() {
        System.out.println("doSomething");
    }
}
