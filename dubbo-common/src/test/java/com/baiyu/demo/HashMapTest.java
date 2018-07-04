package com.baiyu.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author baiyu
 * @description: HashMapTest
 * @date: 2018/7/4
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>(6);
        for (int i = 0; i < 6; i++) {
            map.put(i+"","value"+i);
        }
        one(map);
        two(map);
        three(map);
    }

    public static void one(HashMap<String,String> map){
        long begin = System.currentTimeMillis();
        for (Map.Entry<String,String> entry : map.entrySet()){
            System.out.println("one:"+entry.getKey()+"==="+entry.getValue());
        }
        System.out.println("-================="+(System.currentTimeMillis()-begin));
    }


    public static void two(HashMap<String,String> map){
        long begin = System.currentTimeMillis();
        for (String str : map.keySet()){
            System.out.println("two:"+str+"==="+map.get(str));
        }
        System.out.println("-================="+(System.currentTimeMillis()-begin));
    }


    public static void three(HashMap<String,String> map){
        long begin = System.currentTimeMillis();
        Iterator<Map.Entry<String,String>> iterator  = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            System.out.println("three:"+entry.getKey()+"======"+entry.getValue());
        }
        System.out.println("-====================="+(System.currentTimeMillis()-begin));
    }
}
