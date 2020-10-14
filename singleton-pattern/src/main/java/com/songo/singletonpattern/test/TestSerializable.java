package com.songo.singletonpattern.test;

import com.songo.singletonpattern.service.SingletonEnum;
import com.songo.singletonpattern.service.SingletonPattern1;

import java.io.*;

/**
 * @Author SonGo
 * @Create 2020/10/14 9:25
 * @Description 通过序列化和反序列化 测试 单例的对象是否会改变，单例性枚举完胜
 */
public class TestSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //双检锁单例模式，序列化和反序列话后的对象变了
        SingletonPattern1 instance_1 = SingletonPattern1.getInstance();
        //放文件
        ObjectOutputStream outputStream_1 = new ObjectOutputStream(new FileOutputStream("single_file"));
        outputStream_1.writeObject(instance_1);

        //取文件
        File file_1 = new File("single_file");
        ObjectInputStream inputStream_1 = new ObjectInputStream(new FileInputStream(file_1));
        SingletonPattern1 hungrySingleton_1 = (SingletonPattern1) inputStream_1.readObject();

        System.out.println(instance_1);//com.songo.singletonpattern.service.SingletonPattern1@27c170f0
        System.out.println(hungrySingleton_1);//com.songo.singletonpattern.service.SingletonPattern1@3d494fbf
        System.out.println(instance_1==hungrySingleton_1);//false

        System.out.println("---------------------------------------------");

        //通过枚举单例对象序列化和反序列话后的对象相同
        SingletonPattern1 instance2 = SingletonPattern1.getInstance();
        //放文件
        ObjectOutputStream outputStream2 = new ObjectOutputStream(new FileOutputStream("single_file"));
        outputStream2.writeObject(instance2);
        //取文件
        File file2 = new File("single_file");
        ObjectInputStream inputStream2 = new ObjectInputStream(new FileInputStream(file2));
        SingletonPattern1 hungrySingleton2 = (SingletonPattern1) inputStream2.readObject();

        System.out.println(instance2);//com.songo.singletonpattern.service.SingletonPattern1@27c170f0
        System.out.println(hungrySingleton2);//com.songo.singletonpattern.service.SingletonPattern1@1ddc4ec2
        System.out.println(instance2==hungrySingleton2);//false

        System.out.println("---------------------------------------------");

        //通过枚举单例对象序列化和反序列话后的对象相同
        SingletonEnum instance = SingletonEnum.INSTANCE;
        //放文件
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("single_file"));
        outputStream.writeObject(instance);
        //取文件
        File file = new File("single_file");
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        SingletonEnum hungrySingleton = (SingletonEnum) inputStream.readObject();

        System.out.println(instance);//INSTANCE
        instance.doSomething();
        System.out.println(hungrySingleton);//INSTANCE
        System.out.println(instance==hungrySingleton);//true
    }
}
