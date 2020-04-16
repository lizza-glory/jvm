package com.lizza;

/**
 *
 */
public class ClassLoad_01 {

    public static void main(String[] args){
        System.out.println(Child.c_str);
        System.out.println("=====================");
        System.out.println(Child.p_str);
    }
}

class Parent {

    public static String p_str = "Hello World!";

    /** 类被初始化时, 静态代码块会被执行 **/
    static {
        System.out.println("Parent Static Block!");
    }
}

class Child extends Parent {

    public static String c_str = "Welcome!";

    /** 类被初始化时, 静态代码块会被执行 **/
    static {
        System.out.println("Child Static Block!");
    }
}
