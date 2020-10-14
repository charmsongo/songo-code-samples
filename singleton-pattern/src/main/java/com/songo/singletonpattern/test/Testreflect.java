package com.songo.singletonpattern.test;

import com.songo.singletonpattern.service.SingletonEnum;
import com.songo.singletonpattern.service.SingletonPattern1;
import com.songo.singletonpattern.service.SingletonPattern2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author SonGo
 * @Create 2020/10/14 10:14
 * @Description 单例是否会通过反射得到对象的内容，枚举完胜
 */
public class Testreflect {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class object = SingletonPattern1.class;
        Constructor constructor = object.getDeclaredConstructor();
        constructor.setAccessible(true);

        SingletonPattern1 instance = SingletonPattern1.getInstance();
        SingletonPattern1 newInstance = (SingletonPattern1) constructor.newInstance();

        System.out.println(instance);//com.songo.singletonpattern.service.SingletonPattern1@4d7e1886
        System.out.println(newInstance);//com.songo.singletonpattern.service.SingletonPattern1@3cd1a2f1
        newInstance.SingletonFunction();
        System.out.println(instance == newInstance);//false

        System.out.println("-------------------------------------------------");

        Class object2 = SingletonPattern2.class;
        Constructor constructor2 = object2.getDeclaredConstructor();
        constructor2.setAccessible(true);

        SingletonPattern2 instance2 = SingletonPattern2.getInstance();
        SingletonPattern2 newInstance2 = (SingletonPattern2) constructor2.newInstance();

        System.out.println(instance2);//com.songo.singletonpattern.service.SingletonPattern2@2f0e140b
        System.out.println(newInstance2);//com.songo.singletonpattern.service.SingletonPattern2@7440e464
        System.out.println(instance2 == newInstance2);//false

        System.out.println("-------------------------------------------------");

        Class object1 = SingletonEnum.class;
        Constructor constructor1 = object1.getDeclaredConstructor(String.class,int.class);//枚举没有无参构造方法，这里加上参数
        constructor1.setAccessible(true);


        SingletonEnum instance1 = SingletonEnum.INSTANCE;
        SingletonEnum newInstance1 = (SingletonEnum) constructor1.newInstance();//异常 Cannot reflectively create enum objects

        System.out.println(instance1);
        System.out.println(newInstance1);
        newInstance1.doSomething();
        System.out.println(instance1 == newInstance1);
    }
}
