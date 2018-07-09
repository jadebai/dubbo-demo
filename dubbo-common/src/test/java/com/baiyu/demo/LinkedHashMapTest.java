package com.baiyu.demo;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author baiyu
 * @description: LinkedHashMapTest
 * @date: 2018/7/9
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put("111", "111");
        linkedHashMap.put("222", "222");
        loopLinkedHashMap(linkedHashMap);
        linkedHashMap.get("111");
    }

    public static void loopLinkedHashMap(LinkedHashMap<String, String> linkedHashMap) {
        Set<Map.Entry<String, String>> set = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "\t");
        }
        System.out.println();
    }
}
