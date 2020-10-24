package com.songo.singletonpattern.test;

import com.songo.singletonpattern.service.DCLSingleton;
import com.songo.singletonpattern.service.SingletonEnum;
import com.songo.singletonpattern.service.StaticSingleton;

import java.io.*;

/**
 * @Author SonGo
 * @Create 2020/10/14 9:25
 * @Description 通过序列化和反序列化 测试 单例的对象是否会改变，单例性枚举完胜
 */
public class TestSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /*//序列化到文件
        DCLSingleton instance_1 = DCLSingleton.getInstance();
        //放文件
        ObjectOutputStream outputStream_1 = new ObjectOutputStream(new FileOutputStream("single_file"));
        outputStream_1.writeObject(instance_1);

        //取文件
        File file_1 = new File("single_file");
        ObjectInputStream inputStream_1 = new ObjectInputStream(new FileInputStream(file_1));
        DCLSingleton singleton_1 = (DCLSingleton) inputStream_1.readObject();*/

        //序列化到字节流
        System.out.println("----------------双重否定单例模式测试开始-----------------------------");
        DCLSingleton instance_1 = DCLSingleton.getInstance();
        ByteArrayOutputStream byteArrayOutputStream_1 = new ByteArrayOutputStream();
        new ObjectOutputStream(byteArrayOutputStream_1).writeObject(instance_1);

        ObjectInputStream objectInputStream_1 = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream_1.toByteArray()));
        DCLSingleton singleton_1 = (DCLSingleton) objectInputStream_1.readObject();

        //com.songo.singletonpattern.service.SingletonPattern1@27c170f0
        System.out.println(instance_1);
        //com.songo.singletonpattern.service.SingletonPattern1@3d494fbf
        System.out.println(singleton_1);
        //DCLSingleton test.
        singleton_1.singletonFunction();
        //序列化和反序列化后是否相同:false
        System.out.println("序列化和反序列化后是否相同:" + (instance_1 == singleton_1));
        System.out.println("----------------双重否定单例模式测试结束-----------------------------");

        System.out.println("----------------静态内部类单例模式测试开始---------------------------");
        StaticSingleton instance_2 = StaticSingleton.getInstance();
        ByteArrayOutputStream byteArrayOutputStream_2 = new ByteArrayOutputStream();
        new ObjectOutputStream(byteArrayOutputStream_2).writeObject(instance_2);

        ObjectInputStream objectInputStream_2 = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream_2.toByteArray()));
        StaticSingleton singleton_2 = (StaticSingleton) objectInputStream_2.readObject();

        //com.songo.singletonpattern.service.StaticSingleton@7cd84586
        System.out.println(instance_2);
        //com.songo.singletonpattern.service.StaticSingleton@30dae81
        System.out.println(singleton_2);
        //StaticSingleton test.
        singleton_2.singletonFunction();
        //序列化和反序列化后是否相同:false
        System.out.println("序列化和反序列化后是否相同:" + (instance_2==singleton_2));
        System.out.println("----------------静态内部类单例模式测试结束---------------------------");

        System.out.println("----------------枚举单例模式测试结束---------------------------------");
        SingletonEnum instance_3 = SingletonEnum.INSTANCE;
        ByteArrayOutputStream byteArrayOutputStream_3 = new ByteArrayOutputStream();
        new ObjectOutputStream(byteArrayOutputStream_3).writeObject(instance_3);

        ObjectInputStream objectInputStream_3 = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream_3.toByteArray()));
        SingletonEnum singleton_3 = (SingletonEnum) objectInputStream_3.readObject();

        //INSTANCE
        System.out.println(instance_3);
        //INSTANCE
        System.out.println(singleton_3);
        //SingletonEnum test.
        singleton_3.singletonFunction();
        //序列化和反序列化后是否相同:true
        System.out.println("序列化和反序列化后是否相同:" + (instance_3==singleton_3));
        System.out.println("----------------枚举单例模式测试结束---------------------------------");

    }
}
