package com.lizza.classload;

import java.util.UUID;

/**
 * 1. 当一个常量的值不能在编译器确定, 那么该常量就不会被放到调用类的常量池中
 * 2. 在程序运行时, 会导致主动使用这个常量所在的类, 便会导致该类被初始化
 */
public class ClassLoad_03 {

    public static void main(String[] args){
        System.out.println(Child_03.str);
    }
}

class Child_03 {
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("Child_03 Static code!");
    }
}