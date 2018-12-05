package com.sunlight001.test.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student2 {
	private String name;    // 姓名
    private int age;        // 年龄

    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取学生姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 获取学生年龄
     */
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student2 [name=" + name + ", age=" + age + "]";
    }
    
    public static void main(String[] args) {
        List<Student2> list = new ArrayList<>();     // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        list.add(new Student2("Hao LUO", 33));
        list.add(new Student2("XJ WANG", 32));
        list.add(new Student2("Bruce LEE", 60));
        list.add(new Student2("Bob YANG", 22));

        // 通过sort方法的第二个参数传入一个Comparator接口对象
        // 相当于是传入一个比较对象大小的算法到sort方法中
        // 由于Java中没有函数指针、仿函数、委托这样的概念
        // 因此要将一个算法传入一个方法中唯一的选择就是通过接口回调
        Collections.sort(list, new Comparator<Student2> () {

            @Override
            public int compare(Student2 o1, Student2 o2) {
               return o1.getName().compareTo(o2.getName());    // 比较学生姓名
            }
        });

        for(Student2 stu : list) {
            System.out.println(stu);
        }
//      输出结果: 
//      Student [name=Bob YANG, age=22]
//      Student [name=Bruce LEE, age=60]
//      Student [name=Hao LUO, age=33]
//      Student [name=XJ WANG, age=32]
    }

    
    

}
