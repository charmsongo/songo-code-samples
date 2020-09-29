package com.songo.juc;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author SonGo
 * @Create 2020/9/9 12:35
 * @Description
 */
public class ThreadLocalTest {
    private List<String> messages = new ArrayList<>();

    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String message) {
        holder.get().messages.add(message);
    }

    public static List<String> clear() {
        List<String> messages = holder.get().messages;
        System.out.println("size:"+holder.get().messages.size());
        holder.remove();

        System.out.println("size:"+holder.get().messages.size());
        return messages;
    }

    public static void main(String[] args) throws InterruptedException {
        //ThreadLocalTest.add("一只花算不算浪漫");
        //System.out.println(holder.get().messages);
        //System.out.println(ThreadLocalTest.clear());

        Thread t1 = new Thread(() -> test("abc", false));
        t1.start();
        t1.join();
        System.out.println("---gc后--");
        Thread t2 = new Thread(() -> test("def", true));
        t2.start();
        t2.join();
    }

    private static void test(String s, boolean isGc) {
        try {
            //new ThreadLocal<>().set(s);
            ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
            objectThreadLocal.set(s);
            if (isGc) {
                System.gc();
            }
            Thread t = Thread.currentThread();
            Class<? extends Thread> clz = t.getClass();
            Field field = clz.getDeclaredField("threadLocals");
            field.setAccessible(true);
            Object tlm = field.get(t);
            Class<?> tlmClass = tlm.getClass();
            Field tableFied = tlmClass.getDeclaredField("table");
            tableFied.setAccessible(true);
            Object[] arr = (Object[]) tableFied.get(tlm);
            for (Object o : arr) {
                if (o != null) {
                    Class<?> entryClass = o.getClass();
                    Field valueField = entryClass.getDeclaredField("value");
                    Field referentField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                    valueField.setAccessible(true);
                    referentField.setAccessible(true);
                    System.out.println(String.format("弱引用key:%s,值：%s",referentField.get(o),valueField.get(o)));
                }

            }


        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
