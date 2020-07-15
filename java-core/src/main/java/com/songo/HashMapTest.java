package com.songo;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created By GS 10:39 2020/5/14
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(1,2);
        hashMap.remove(1);
        System.out.println(System.identityHashCode("a"));
        System.out.println("a".hashCode());


        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, 2);
        concurrentHashMap.get(1);
        concurrentHashMap.size();

        assert 1 == 2;
        System.out.println("12");

        LongAdder longAdder = new LongAdder();
        longAdder.add(1);
        System.out.println(longAdder);

    }
}
