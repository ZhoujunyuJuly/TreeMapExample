package com.example.lib;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * @see TreeMap 实现了
 * @see NavigableMap 接口
 * 该类是对 NavigableMap 的使用
 */
public class NavigatorTreeMap {
    public static void main(String[] args) {

        // NavigableMap多态接收TreeMap的实例
        NavigableMap<String, Integer> navigatorTreeMap = new TreeMap<String, Integer>() {{
            put("aa", 11);
            put("bb", 22);
            put("cc", 33);
            put("dd", 44);
            put("ee", 55);
            put("ff", 55);
            put("gg", 55);
        }};


        System.out.println(navigatorTreeMap.size());// 7个元素：7
        // 返回大于等于cc的最小键：cc
        System.out.println("ceilingKey:\n返回大于等于cc的最小键：" + navigatorTreeMap.ceilingKey("cc") + "\n");
        //  返回一个键-值映射关系，它与大于等于cc的最小键关联：cc=33
        System.out.println("ceilingEntry:\n返回一个键-值映射关系，它与大于等于cc的最小键关联:" + navigatorTreeMap.ceilingEntry("c")+ "\n");
        // 最小键:aa
        System.out.println("firstKey:\n最小键:" + navigatorTreeMap.firstKey()+ "\n");
        // 最小键对应的k-v键值对：aa=11
        System.out.println("firstEntry:\n最小键对应的k-v键值对:" + navigatorTreeMap.firstEntry()+ "\n");


        // 返回一个键-值映射关系，它与小于等于给定键的最大键关联:bb=22
        System.out.println("floorEntry:\n返回一个键-值映射关系，它与小于等于给定键的最大键关联:"+ navigatorTreeMap.floorEntry("c")+ "\n");
        //   返回小于等于cc的最大键:cc
        System.out.println("floorKey:\n返回小于等于cc的最大键:"+ navigatorTreeMap.floorKey("cc")+ "\n");
        // 返回此映射的部分视图，其键值严格小于bb:{aa=11}
        System.out.println("headMap:\n返回此映射的部分视图，其键值严格小于b:" + navigatorTreeMap.headMap("bb")+ "\n");
        // 同上小于等于（true）:{aa=11, bb=22}
        System.out.println("headMap:\n同上小于等于bb（true:" + navigatorTreeMap.headMap("bb", true)+ "\n");
        // 返回一个键-值映射关系，它与小于等于给定键的最大键关联:cc=33
        System.out.println("higherEntry:\n返回一个键-值映射关系，它与小于等于给定键的最大键关联:" + navigatorTreeMap.higherEntry("c")+ "\n");
        //   返回小于等于cc的最大键:dd
        System.out.println("higherKey:\n返回小于等于cc的最大键:"+navigatorTreeMap.higherKey("cc")+ "\n");
        // 返回一个键-值映射关系，它与小于等于给定键的最大键关联:gg=55
        System.out.println("lastEntry:\n返回一个键-值映射关系，它与小于等于给定键的最大键关联:" + navigatorTreeMap.lastEntry()+ "\n");
        //   返回小于等于cc的最大键:gg
        System.out.println("lastKey:\n返回小于等于cc的最大键:" + navigatorTreeMap.lastKey()+ "\n");
        // 返回一个键-值映射关系，它与小于等于给定键的最大键关联:bb=22
        System.out.println("lowerEntry:\n返回一个键-值映射关系，它与小于等于给定键的最大键关联:" + navigatorTreeMap.lowerEntry("c")+ "\n");
        //    返回严格小于cc的最大键:bb
        System.out.println("lowerKey:\n返回严格小于cc的最大键:" + navigatorTreeMap.lowerKey("cc")+ "\n");
        //  移除并返回与此映射中的最小键关联的键-值映射关系:aa=11
        System.out.println("pollFirstEntry:\n移除并返回与此映射中的最小键关联的键-值映射关系:" + navigatorTreeMap.pollFirstEntry()+ "\n");
        //  移除并返回与此映射中的最大键关联的键-值映射关系:gg=55
        System.out.println("pollLastEntry:\n移除并返回与此映射中的最大键关联的键-值映射关系:" + navigatorTreeMap.pollLastEntry()+ "\n");
        //   返回此映射中所包含键的
        System.out.println("navigableKeySet:\n返回此映射中所包含键的:" + navigatorTreeMap.navigableKeySet()+ "\n");
        // NavigableSet 视图。:[bb, cc, dd, ee, ff]

        // 返回部分视图，true表示包括当前元素键值对:{bb=22, cc=33, dd=44}
        System.out.println("subMap:\n返回部分视图，true表示包括当前元素键值对:" + navigatorTreeMap.subMap("aa", true, "dd", true)+ "\n");
        // 返回部分视图包括前面的元素，不包括后面的：{bb=22, cc=33}
        System.out.println("subMap:\n返回部分视图包括前面的元素，不包括后面的:"+navigatorTreeMap.subMap("bb", "dd")+ "\n");
        // 返回元素大于cc的元素映射视图,包括cc：//{cc=33, dd=44, ee=55, ff=55}
        System.out.println("tailMap:\n返回元素大于cc的元素映射视图,包括cc: " + navigatorTreeMap.tailMap("cc")+ "\n");
        // 返回元素大于等于cc的元素映射视图:{dd=44, ee=55, ff=55}
        System.out.println("tailMap:\n返回元素大于等于cc的元素映射视图:" + navigatorTreeMap.tailMap("cc", false)+ "\n");

        //逆序视图
        NavigableMap<String, Integer> descendingMap = navigatorTreeMap.descendingMap();
        //原来的Map：
        System.out.println("原来的Map：" + navigatorTreeMap+ "\n");
        // 返回逆序视图:{gg=55, ff=55, ee=55, dd=44, cc=33, bb=22, aa=11}
        System.out.println("descendingMap:\n返回逆序视图:" + descendingMap + "\n");
        //执行一个移除操作后  再看看会不会影响到原来的Map
        descendingMap.remove("gg");
        System.out.println("移除一个gg之后：\n");
        //原来的Map：{aa=11, bb=22, cc=33, dd=44, ee=55, ff=55}
        System.out.println("原来的Map:" + navigatorTreeMap+ "\n");
        // 返回逆序视图:{ff=55, ee=55, dd=44, cc=33, bb=22, aa=11}
        System.out.println("返回逆序视图:" + descendingMap+ "\n");
    }

}
