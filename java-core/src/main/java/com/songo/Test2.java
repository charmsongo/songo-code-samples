package com.songo;


import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Author SonGo
 * @Create 2020/6/24 16:04
 * @Description
 */
public class Test2 {

    private Person p ;
    public static void main(String[] args) {
        //Object obj = new Son();
        //Son son = new Son();
        //Parent parent = new Parent();
        //System.out.println(obj.getClass() == son.getClass());
        //System.out.println(son instanceof Parent);
        //System.out.println(Parent.class.isAssignableFrom(son.getClass()));

        //System.out.println(true ^ true);
        //String a = "+1243";
        //if (a.startsWith("+")) {
        //    System.out.println(a.substring(1));
        //}
        //
        //
        //String adfasf  = "12312";
        //if (StringUtils.isEmpty(adfasf)) {
        //    System.out.println(adfasf);
        //}
        //try {
        //    Son son = new Son();
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}

        //ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        //concurrentHashMap.get(null);

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }
        /*
         * [6]Monitor Ctrl-Break
         * [5]Attach Listener //添加事件
         * [4]Signal Dispatcher // 分发处理给 JVM 信号的线程
         * [3]Finalizer //调用对象 finalize 方法的线程
         * [2]Reference Handler //清除 reference 线程
         * [1]main //main 线程,程序入口
         */

    }
}
