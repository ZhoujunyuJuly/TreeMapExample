package com.example.lib;

import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.UUID;

public class HashMapCompater {
    public static void main(String[] args) {

        HashMap<String,String> Hash = new HashMap<>();

        TreeMap<String,String> tree = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        int count = 10000000;
        System.out.println("测试数据量：" + count / 10000 + "w");
        System.out.println("---------------------开始添加数据--------------------");

        Instant inst1 = Instant.now();
        System.out.println("往hashmap中push数据开始：" + inst1);
        for(int i = 0;i<count;i++){
            Hash.put(UUID.randomUUID().toString(),"abc"+i);
        }
        Instant inst2 = Instant.now();
        System.out.println("往hashmap中push数据结束：" + inst2);
        System.out.println("hashmap总耗时：" + Duration.between(inst1,inst2).toMillis());

        Instant inst3 = Instant.now();
        System.out.println("往treemap中push数据开始：" + inst3);
        for(int i = 0;i<count;i++){
            tree.put(UUID.randomUUID().toString(),"abc"+i);
        }
        Instant inst4 = Instant.now();
        System.out.println("往treemap中push数据结束：" + inst4);
        System.out.println("treemap总耗时：" + Duration.between(inst3,inst4).toMillis());

        System.out.println("---------------------开始查找数据--------------------");

        Instant inst5 = Instant.now();
        System.out.println("hashmap中查找数据开始：" + inst5);
        Hash.get(UUID.randomUUID().toString());
        Instant inst6 = Instant.now();
        System.out.println("hashmap中查找数据结束：" + inst6);
        System.out.println("hashmap总耗时：" + Duration.between(inst5,inst6).toMillis());

        Instant inst7 = Instant.now();
        System.out.println("treemap中查找数据开始：" + inst7);
        tree.get(UUID.randomUUID().toString());
        Instant inst8 = Instant.now();
        System.out.println("往treemap中push数据结束：" + inst8);
        System.out.println("treemap总耗时：" + Duration.between(inst7,inst8).toMillis());
    }
}
