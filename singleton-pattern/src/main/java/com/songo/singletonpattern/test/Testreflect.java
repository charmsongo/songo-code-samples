package com.songo.singletonpattern.test;

import com.songo.singletonpattern.service.DCLSingleton;
import com.songo.singletonpattern.service.SingletonEnum;
import com.songo.singletonpattern.service.StaticSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author SonGo
 * @Create 2020/10/14 10:14
 * @Description 单例是否会通过反射得到对象的内容，安全性枚举完胜
 */
public class Testreflect {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        System.out.println("----------------双重否定单例模式测试开始-----------------------------");
        DCLSingleton instance_1 = DCLSingleton.getInstance();
        Constructor constructor_1 = DCLSingleton.class.getDeclaredConstructor();
        constructor_1.setAccessible(true);
        DCLSingleton newInstance_1 = (DCLSingleton) constructor_1.newInstance();

        //com.songo.singletonpattern.service.SingletonPattern1@4d7e1886
        System.out.println(instance_1);
        //com.songo.singletonpattern.service.SingletonPattern1@3cd1a2f1
        System.out.println(newInstance_1);
        //DCLSingleton test.
        newInstance_1.singletonFunction();
        //通过反射得到的对象和原来是否相同:false
        System.out.println("通过反射得到的对象和原来是否相同:" + (instance_1 == newInstance_1));
        System.out.println("----------------双重否定单例模式测试结束-----------------------------");

        System.out.println("----------------静态内部类单例模式测试开始---------------------------");
        StaticSingleton instance_2 = StaticSingleton.getInstance();
        Constructor constructor_2 = StaticSingleton.class.getDeclaredConstructor();
        constructor_2.setAccessible(true);
        StaticSingleton newInstance_2 = (StaticSingleton) constructor_2.newInstance();

        //com.songo.singletonpattern.service.SingletonPattern2@2f0e140b
        System.out.println(instance_2);
        //com.songo.singletonpattern.service.SingletonPattern2@7440e464
        System.out.println(newInstance_2);
        //StaticSingleton test.
        newInstance_2.singletonFunction();
        //通过反射得到的对象和原来是否相同:false
        System.out.println("通过反射得到的对象和原来是否相同:" + (instance_2 == newInstance_2));
        System.out.println("----------------静态内部类单例模式测试结束---------------------------");

        System.out.println("----------------枚举单例模式测试开始---------------------------------");
        //枚举没有无参构造方法，这里加上参数
        SingletonEnum instance_3 = SingletonEnum.INSTANCE;
        Constructor constructor_3 = SingletonEnum.class.getDeclaredConstructor(String.class,int.class);
        constructor_3.setAccessible(true);
        //异常 Cannot reflectively create enum objects
        SingletonEnum newInstance_3 = (SingletonEnum) constructor_3.newInstance("test",111);

        System.out.println(instance_3);
        System.out.println(newInstance_3);
        newInstance_3.singletonFunction();
        System.out.println(instance_3 == newInstance_3);
        System.out.println("----------------枚举单例模式测试结束---------------------------------");
    }
}
