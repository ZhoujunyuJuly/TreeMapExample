package com.example.lib;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class MyClass {
    public static void main(String[] args) {
        System.out.println("hello word");

        TreeMapFunction<Student,Integer> mTreeMap = new TreeMapFunction<>(new TreeMap<Student,Integer>(new Comparator<Student>() {
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
        Set<Map.Entry<Student, Integer>> entries = mTreeMap.entrySet();
        Iterator<Map.Entry<Student, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Student, Integer> next = iterator.next();
            if( next.getKey().name.equals(chooseStudent.name)){
                println(String.format("【【【%s,分数：%d,身高：%d】】】<--------随机选取这位",next.getKey().name,next.getKey().grade,next.getValue()));
            }else {
                println(String.format("%s,分数：%d,身高：%d",next.getKey().name,next.getKey().grade,next.getValue()));
            }

        }

        println("\n--------------------------------");
        println(String.format("随机选取【【【 %s 】】】",chooseStudent.name));
        //lowerKey
        println(String.format("\nlowerKey(K key) & lowerEntry()\n==排在 %s (%s) 前面的第一个人是：%s (%s)",chooseStudent.name,chooseStudent.grade,
                mTreeMap.lowerKey((chooseStudent)).name,mTreeMap.lowerKey((chooseStudent)).grade));
        println(String.format("\nfloorKey(K key) & floorEntry()\n：分数小于等于 %s (%s) 的第一个人是：%s (%s)",chooseStudent.name,chooseStudent.grade,
                mTreeMap.floorKey((chooseStudent)).name,mTreeMap.floorKey((chooseStudent)).grade));
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