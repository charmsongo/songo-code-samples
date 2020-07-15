package com.songo;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created By GS 8:35 2020/4/25
 */
public class TestItrator {

    public static void main(String[] args) {

        //ArrayList<String> arrayList = new ArrayList<>();
        //arrayList.add("1");
        //arrayList.get(0);
        //arrayList.remove("1");
        //arrayList.size();
        //
        //HashSet<String> set =new HashSet<>();
        //set.add("11");
        //set.remove("11");
        //set.size();

        //HashMap<String, Integer> map11 = new HashMap<>(1,1);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        //map.get("2");
        //map.remove("2");
        map.putIfAbsent("2",22);
        map.put("2",222);
        map.size();

        //ConcurrentHashMap<String, Integer> map1 = new ConcurrentHashMap<>();
        //map1.put("1",1);
        //map1.put("2",2);
        //map1.put("3",3);
        //map1.get("2");
        //map1.remove("2");
        //map1.size();

        Iterator<String> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            String next =  iterator.next();
            if("1".equals(next)){
                //map.remove(next);
                iterator.remove();
            }
        }

        for (String str : map.keySet()) {
            System.out.println(map.get(str));
        }

        System.out.println(Integer.numberOfLeadingZeros(16));
        //16
        //1 0000
        //System.out.println(Integer.highestOneBit(16));
        //System.out.println(Integer.highestOneBit(15));
        //System.out.println(Integer.highestOneBit(17));
        System.out.println(StringUtils.hasLength(""));
    }
}
