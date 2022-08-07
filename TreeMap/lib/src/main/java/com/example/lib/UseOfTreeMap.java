package com.example.lib;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class UseOfTreeMap {
    public static void main(String[] args) {
        System.out.println("hello word");

        TreeMapUtils<Student,Integer> mTreeMap = new TreeMapUtils<>(new TreeMap<Student,Integer>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.grade - o1.grade;
            }
        }));

        List<Student> list = getData();
        println("无序输入的数据如下：");
        for( Student student : list){
            mTreeMap.put(student,student.tall);
            println(String.format("%s,分数：%d,身高：%d",student.name,student.grade,student.tall));
        }


        Random random = new Random();
        int index = random.nextInt(list.size());

        println("\n按照分数排队，分数高的在前面：");
        Student chooseStudent = list.get(index);
        Student newStudent = new Student("插班生",82,144);
        Set<Map.Entry<Student, Integer>> entries = mTreeMap.entrySet();
        Iterator<Map.Entry<Student, Integer>> iterator = entries.iterator();
        boolean isFindNewStudent = false;
        while (iterator.hasNext()){
            Map.Entry<Student, Integer> next = iterator.next();
            if( next.getKey().name.equals(chooseStudent.name)){
                println(String.format("【【【%s,分数：%d,身高：%d】】】<--------随机选取这位",next.getKey().name,next.getKey().grade,next.getValue()));
            }else if( !isFindNewStudent && next.getKey().grade < newStudent.grade){
                println(String.format("<---------------------------%s(分数：%d,身高：%d)将要入队",newStudent.name,newStudent.grade,newStudent.tall));
                println(String.format("%s,分数：%d,身高：%d",next.getKey().name,next.getKey().grade,next.getValue()));
                isFindNewStudent = true;
            }else {
                println(String.format("%s,分数：%d,身高：%d",next.getKey().name,next.getKey().grade,next.getValue()));
            }

        }

        println("\n--------------------------------");
        println(String.format("随机选取【【【 %s 】】】和不在队列中的【【【%s】】】",chooseStudent.name,newStudent.name));
        //lowerKey
        println(String.format("\nlowerKey(K key) & lowerEntry()\n==排在 %s (%s) 前面的第一个人是：%s (%s)",chooseStudent.name,chooseStudent.grade,
                mTreeMap.lowerKey((chooseStudent)).name,mTreeMap.lowerKey((chooseStudent)).grade));
        println(String.format("==排在 %s (%s) 前面的第一个人是：%s (%s)",newStudent.name,newStudent.grade,
                mTreeMap.lowerKey((newStudent)).name,mTreeMap.lowerKey((newStudent)).grade));
        //floorKey
        println(String.format("\nfloorKey(K key) & floorEntry()\n==排在 %s (%s) 前面(包括%s)的第一个人是：%s (%s)",chooseStudent.name,chooseStudent.grade,
                chooseStudent.name, mTreeMap.floorKey((chooseStudent)).name,mTreeMap.floorKey((chooseStudent)).grade));
        println(String.format("==排在 %s (%s) 前面(包括%s)的第一个人是：%s (%s)",newStudent.name,newStudent.grade,newStudent.name,
                mTreeMap.lowerKey((newStudent)).name,mTreeMap.lowerKey((newStudent)).grade));
        //higherKey
        println(String.format("\nhigherKey(K key) & higherEntry()\n==排在 %s (%s) 后面的第一个人是：%s (%s)",chooseStudent.name,chooseStudent.grade,
                mTreeMap.higherKey((chooseStudent)).name,mTreeMap.higherKey((chooseStudent)).grade));
        println(String.format("==排在 %s (%s) 后面的第一个人是：%s (%s)",newStudent.name,newStudent.grade,
                mTreeMap.higherKey((newStudent)).name,mTreeMap.higherKey((newStudent)).grade));
        //ceilingKey
        println(String.format("\nceilingKey(K key) & ceilingKey()\n==排在 %s (%s) 后面(包括%s)的第一个人是：%s (%s)",chooseStudent.name,chooseStudent.grade,
                chooseStudent.name, mTreeMap.ceilingKey((chooseStudent)).name,mTreeMap.ceilingKey((chooseStudent)).grade));
        println(String.format("==排在 %s (%s) 后面(包括%s)的第一个人是：%s (%s)",newStudent.name,newStudent.grade,newStudent.name,
                mTreeMap.ceilingKey((newStudent)).name,mTreeMap.ceilingKey((newStudent)).grade));
        //firstEntry
        println(String.format("\nfirstEntry() \n==排在整个队伍的第一个人是：%s (%s)", mTreeMap.firstEntry().getKey().name,mTreeMap.firstEntry().getKey().grade));
        //lastEntry
        println(String.format("\nlastEntry()\n==排在整个队伍的最后一名是：%s (%s)", mTreeMap.lastEntry().getKey().name,mTreeMap.lastEntry().getKey().grade));

        //descendingMap
        println("\ndescendingMap() & descendingKeySet()\n==逆序视图");
        NavigableMap<Student, Integer> navigableMap = mTreeMap.descendingMap();
        Iterator<Map.Entry<Student, Integer>> navigableIterator = navigableMap.entrySet().iterator();
        while (navigableIterator.hasNext()){
            Map.Entry<Student, Integer> next = navigableIterator.next();
            println(String.format("%s,分数：%d,身高：%d",next.getKey().name,next.getKey().grade,next.getValue()));
        }
        //subMap
        println(String.format("\nsubMap(fromK,true,toK,false) 参数 true 表示是否包括起始/终止数据\n==截取范围 fromK = %s,toK = %s",list.get(1).name,list.get(5).name));
        NavigableMap<Student, Integer> subMap = mTreeMap.subMap(list.get(1),true,list.get(5),true);
        Iterator<Map.Entry<Student, Integer>> subMapIterator = subMap.entrySet().iterator();
        while (subMapIterator.hasNext()){
            Map.Entry<Student, Integer> next = subMapIterator.next();
            println(String.format("%s,分数：%d,身高：%d",next.getKey().name,next.getKey().grade,next.getValue()));
        }

        //subMap
        println(String.format("\nsubMap(fromK,true,toK,false) 不传参数,默认包括fromK,不包括toK\n==截取范围 fromK = %s,toK = %s",list.get(1).name,list.get(5).name));
        SortedMap<Student, Integer> sortMap = mTreeMap.subMap(list.get(1),list.get(5));
        Iterator<Map.Entry<Student, Integer>> sortMapIterator = sortMap.entrySet().iterator();
        while (sortMapIterator.hasNext()){
            Map.Entry<Student, Integer> next = sortMapIterator.next();
            println(String.format("%s,分数：%d,身高：%d",next.getKey().name,next.getKey().grade,next.getValue()));
        }

        //headMap
        println(String.format("\nheadMap(fromK)默认返回【小于】K的数，添加参数true可指定是否包含K \n==排在 %s(%s)前面的数",list.get(4).name,list.get(4).grade));
        SortedMap<Student, Integer> headMap = mTreeMap.headMap(list.get(4));
        Iterator<Map.Entry<Student, Integer>> headMapIterator = headMap.entrySet().iterator();
        while (headMapIterator.hasNext()){
            Map.Entry<Student, Integer> next = headMapIterator.next();
            println(String.format("%s,分数：%d,身高：%d",next.getKey().name,next.getKey().grade,next.getValue()));
        }

        //tailMap
        println(String.format("\ntailMap(fromK)默认返回大于【等于】K的数，添加参数true可指定是否包含K \n==排在 %s(%s)后面的数",list.get(4).name,list.get(4).grade));
        SortedMap<Student, Integer> tailMap = mTreeMap.tailMap(list.get(4));
        Iterator<Map.Entry<Student, Integer>> tailMapIterator = tailMap.entrySet().iterator();
        while (tailMapIterator.hasNext()){
            Map.Entry<Student, Integer> next = tailMapIterator.next();
            println(String.format("%s,分数：%d,身高：%d",next.getKey().name,next.getKey().grade,next.getValue()));
        }





    }

    static class Student{
        String name;
        int grade;
        int tall;

        public Student(String name, int grade,int tall) {
            this.name = name;
            this.grade = grade;
            this.tall = tall;
        }
    }

    public static List<Student> getData(){
        List<Student> list = new ArrayList<>();
        list.add(new Student("Bill",81,181));
        list.add(new Student("Jenny",90,170));
        list.add(new Student("Andrew",62,174));
        list.add(new Student("Linda",93,160));
        list.add(new Student("Lucy",88,165));
        list.add(new Student("Jack",54,166));
        list.add(new Student("Monkey",54,163));
        list.add(new Student("Candy",99,162));
        return list;
    }

    public static void println(String str){
        System.out.println(str);
    }
}