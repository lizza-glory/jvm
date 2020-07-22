package com.lizza;

import java.util.Date;

/**
 * 虚方法表
 * 1. 针对于方法动态分派过程, Java虚拟机在类的方法区建立了虚方法表的数据结构(virtual method table, vtable)
 * 2. 针对于invokeinterface指令来讲, Java虚拟机会建立一个叫做接口方法表的数据结构(interface method table, itablen)
 */
public class ByteCode_07 {

    public static void main(String[] args){
        Animal animal = new Animal();
        Animal dog = new Dog();

        animal.test("hello");
        dog.test(new Date());
    }
}

class Animal {

    public void test(String s) {
        System.out.println("Animal String");
    }

    public void test(Date date) {
        System.out.println("Animal Date");
    }
}

class Dog extends Animal {

    @Override
    public void test(String s) {
        System.out.println("Dog String");
    }

    @Override
    public void test(Date date) {
        System.out.println("Dog Date");
    }
}
